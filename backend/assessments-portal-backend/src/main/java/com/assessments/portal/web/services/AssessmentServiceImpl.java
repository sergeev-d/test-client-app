package com.assessments.portal.web.services;

import com.assessments.portal.web.domain.assessment.*;
import com.assessments.portal.web.repository.AssessmentRepository;
import com.assessments.portal.web.repository.AssessmentResultRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class AssessmentServiceImpl implements AssessmentService {
    @Autowired
    private AssessmentRepository assessmentRepository;
    @Autowired
    private AssessmentResultRepository assessmentResultRepository;
    private ObjectMapper mapper = new ObjectMapper();

    public AssessmentServiceImpl() {}

    @Override
    public List<Assessment> getAssessmentsById(Long userId) {
        List<Assessment> assessments = new ArrayList<>();
        assessmentRepository.findByUserId(userId).forEach(a -> {
            try {
                Context context = mapper.readValue(a.getContext(), Context.class);
                assessments.add(new Assessment()
                        .withId(a.getId())
                        .withName(a.getName())
                        .withCreateDate(a.getCreatedDate())
                        .withComment(a.getComment())
                        .withCompanyTypeId(a.getCompanyTypeId())
                        .withIndustryId(a.getIndustryId())
                        .withDescription(a.getDescription())
                        .withStatus(a.getStatus())
                        .withUserId(a.getUserId())
                        .withQuestionBlocks(context.getQuestionBlocks())
                        .withGlobalRecommendations(context.getGlobalRecommendations())
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return assessments;
    }

    @Override
    public List<Assessment> getAllAssessments() {
        final List<Assessment> assessments = new ArrayList<>();
        final List<AssessmentDAO> results = assessmentRepository.findAll();

        if (Objects.nonNull(results) && !results.isEmpty()){
            results.stream()
                    .filter(a -> a.getStatus().equals(AssessmentStatus.ACTIVE.getStatus()))
                    .forEach(a -> {
                        try {
                            Context context = mapper.readValue(a.getContext(), Context.class);
                            assessments.add(new Assessment()
                                    .withId(a.getId())
                                    .withName(a.getName())
                                    .withCreateDate(a.getCreatedDate())
                                    .withComment(a.getComment())
                                    .withCompanyTypeId(a.getCompanyTypeId())
                                    .withIndustryId(a.getIndustryId())
                                    .withDescription(a.getDescription())
                                    .withStatus(a.getStatus())
                                    .withUserId(a.getUserId())
                                    .withQuestionBlocks(context.getQuestionBlocks())
                                    .withGlobalRecommendations(context.getGlobalRecommendations())
                            );
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }

        return assessments;
    }

    @Override
    public Long addAssessment(Assessment assessment, Long userId) {
        try {
            Context context = new Context()
                    .withQuestions(assessment.getQuestionBlocks())
                    .withGlobalRecommendations(assessment.getGlobalRecommendations());
            String contextAsString = mapper.writeValueAsString(context);
            AssessmentDAO assessmentDAO = AssessmentDAO.create(assessment.getName(), assessment.getDescription(),
                    assessment.getStatus(), assessment.getComment(), assessment.getCompanyTypeId(), assessment.getIndustryId(),
                    userId, Date.from(Instant.now()), null, contextAsString);
            AssessmentDAO nAssessment = assessmentRepository.save(assessmentDAO);
            assessmentResultRepository.flush();
            return nAssessment.getId();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteAssessment(Long id) {
        AssessmentDAO assessment = assessmentRepository.findById(id).get();
        assessment.changeStatus(AssessmentStatus.INACTIVE.getStatus());
        assessmentRepository.save(assessment);
    }

    @Override
    public void updateAssessment(Assessment assessment) {
        try {
            AssessmentDAO dbAssessment = assessmentRepository.findById(assessment.getId()).get();

            Context context = new Context()
                    .withQuestions(assessment.getQuestionBlocks())
                    .withGlobalRecommendations(assessment.getGlobalRecommendations());

            String contextAsString = mapper.writeValueAsString(context);

            dbAssessment.setComment(assessment.getComment());
            dbAssessment.setCompanyTypeId(assessment.getCompanyTypeId());
            dbAssessment.setIndustryId(assessment.getIndustryId());
            dbAssessment.setContext(contextAsString);
            dbAssessment.setDescription(assessment.getDescription());
            dbAssessment.setName(assessment.getName());
            dbAssessment.setUpdatedDate(Date.from(Instant.now()));

            assessmentRepository.save(dbAssessment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAssessmentResult(Long userId, AssessmentResult result) {
        try {
            ResultContext context = new ResultContext();
            context.setBlocksResults(result.getResultBlockData());
            context.setBlocks(result.getBlocks());

            AssessmentResultDAO assessmentResultDAO = new AssessmentResultDAO();
            assessmentResultDAO.setUserId(userId);
//        assessmentResultDAO.setBlocks(result.getBlocks());
            assessmentResultDAO.setRecommendation(result.getRecommendation());
            assessmentResultDAO.setCreateDate(Date.from(Instant.now()));
//        assessmentResultDAO.setBlocksResultData(result.getResultBlockData());
            assessmentResultDAO.setAssessmentName(result.getAssessmentName());
            assessmentResultDAO.setAssessmentId(result.getAssessmentId());
            assessmentResultDAO.setCtx(mapper.writeValueAsString(context));

            assessmentResultRepository.save(assessmentResultDAO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AssessmentResult> getAssessmentsResult(Long userId) {
        List<AssessmentResult> assessmentResults = new ArrayList<>();
        assessmentResultRepository.findAll()
                .stream()
                    .filter(r -> r.getUserId().longValue() == userId.longValue())
                    .forEach(r -> {
                        try {
                            ResultContext ctx = mapper.readValue(r.getCtx(), ResultContext.class);
                            assessmentResults.add(new AssessmentResult()
                                    .withAssessmentId(r.getAssessmentId())
                                    .withAssessmentName(r.getAssessmentName())
                                    .withCreateDate(r.getCreateDate())
                                    .withBlocks(ctx.getBlocks())
                                    .withResultBlockData(ctx.getBlocksResults())
                                    .withRecommendation(r.getRecommendation())
                            );
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    });


        return assessmentResults;
    }

}
