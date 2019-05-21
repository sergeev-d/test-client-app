package com.assessments.portal.web.services;

import com.assessments.portal.web.domain.assessment.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public class AssessmentServiceImpl implements AssessmentService {
    private ConcurrentHashMap<Long, Assessment> userAssessments;
    private ConcurrentHashMap<Long, Assessment> allAssessments;
    private AtomicLong currentId = new AtomicLong(0);

    public AssessmentServiceImpl() {
        this.userAssessments = new ConcurrentHashMap<>();
        this.allAssessments = new ConcurrentHashMap<>();

        Assessment assessmentId1 = new Assessment();
        Long firstId = currentId.incrementAndGet();
        assessmentId1.setId(firstId);
        assessmentId1.setName("Тестовая оценка");
        assessmentId1.withStatus("На рассмотрении");
        assessmentId1.setComment("Тестовый комментарий");

        Assessment assessmentId2 = new Assessment();
        Long secondId = currentId.incrementAndGet();
        assessmentId2.setId(secondId);
        assessmentId2.setName("Тестовая оценка2");
        assessmentId2.withStatus("Новая");
        assessmentId2.setComment("");


        /* Productive assessment */
        List<Question> qBlock1 = new ArrayList<>();
        qBlock1.add(new Question()
                .withId(1L)
                .withValue("Наш  ежегодный процесс планирования включает в себя инициативы и проекты по улучшению")
        );
        qBlock1.add(new Question()
                .withId(2L)
                .withValue("Наша стратегия обсуждаема и хорошо понятна работникам")
        );
        qBlock1.add(new Question()
                .withId(3L)
                .withValue("Наше  руководство помогает организации знать, что нужно знать, чтобы быть успешным")
        );
        qBlock1.add(new Question()
                .withId(4L)
                .withValue("У нашей организации прогрессивное мышление и управление, демонстрирующие необходимые действия в управлении организацией для достижения ее целей")
        );

        List<Question> qBlock2 = new ArrayList<>();
        qBlock2.add(new Question()
                .withId(1L)
                .withValue("Наша система управления ориентирована на удовлетворение потребностей клиентов")
        );
        qBlock2.add(new Question()
                .withId(2L)
                .withValue("Наша система управления соответствует стратегиям, целям и действиям организации")
        );
        qBlock2.add(new Question()
                .withId(3L)
                .withValue("Наша система управления предназначена для постоянного совершенствования нашей продукции и услуг")
        );
        qBlock2.add(new Question()
                .withId(4L)
                .withValue("Существуют проверки и балансы, обеспечивающие соответствие продуктов,  услуг и процессов стандартам, установленным организацией")
        );
        qBlock2.add(new Question()
                .withId(5L)
                .withValue("В случае выявления проблем Ваша организация использует надлежащие методы повышения производительности " +
                        "для эффективной идентификации проекта, диагностики корня проблемы (коренных причин) и реализации решений")
        );


        List<QuestionBlock> questionBlocks = new ArrayList<>();
        questionBlocks.add(
                new QuestionBlock()
                        .withBlock(
                                new Block()
                                        .withName("Стратегическое планирование и развитие)")
                                        .withQuestions(qBlock1)
                                        .withRecommendations(Collections.emptyList())
                        )
        );
        questionBlocks.add(
                new QuestionBlock()
                        .withBlock(
                                new Block()
                                        .withName("Управление качеством")
                                        .withQuestions(qBlock2)
                                        .withRecommendations(Collections.emptyList())
                        )
        );

        Assessment assessmentId3 = new Assessment();
        Long thirdId = currentId.incrementAndGet();
        assessmentId3.setId(thirdId);
        assessmentId3.setName("Продуктивная оценка");
        assessmentId3.setComment("");
        assessmentId3.setUserId(1L);
        assessmentId3.setCompanyTypeId(2);
        assessmentId3.setIndustryId(2);
        assessmentId3.setDescription("Продуктивная оценка");
        assessmentId3.setStatus("Активная");
        assessmentId3.setQuestionBlocks(questionBlocks);


        userAssessments.put(firstId, assessmentId1);
        userAssessments.put(secondId, assessmentId2);

        allAssessments.put(firstId, assessmentId1);
        allAssessments.put(secondId, assessmentId2);
        allAssessments.put(thirdId, assessmentId3);
    }

    @Override
    public List<Assessment> getAssessmentsById(Long userId) {
        List<Assessment> assessments = new ArrayList<>();
        userAssessments.forEach((key, value) -> assessments.add(value));

        return assessments;
    }

    @Override
    public List<Assessment> getAllAssessments() {
        List<Assessment> assessments = new ArrayList<>();
        allAssessments.forEach((key, value) -> assessments.add(value));

        return assessments;
    }

    @Override
    public Long addAssessment(Assessment assessment, Long userId) {
        Long id = currentId.incrementAndGet();
        assessment.setUserId(userId);
        assessment.setId(id);
        userAssessments.putIfAbsent(id, assessment);

        return id;
    }

    @Override
    public void deleteAssessment(Long id) {
        userAssessments.remove(id);
    }

    @Override
    public void updateAssessment(Assessment assessment) {
        userAssessments.replace(assessment.getId(), assessment);
    }

    @Override
    public List<AssessmentResult> getAssessmentsResult(Long userId) {
        return null;
    }

}
