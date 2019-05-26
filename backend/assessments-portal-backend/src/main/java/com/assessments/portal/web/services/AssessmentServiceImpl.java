package com.assessments.portal.web.services;

import com.assessments.portal.web.domain.assessment.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public class AssessmentServiceImpl implements AssessmentService {
    private ConcurrentHashMap<Long, Assessment> userAssessments;
    private ConcurrentHashMap<Long, Assessment> allAssessments;
    private AtomicLong currentId = new AtomicLong(0);
    private AtomicLong currentAssessmentResultId = new AtomicLong(0);
    private ConcurrentHashMap<Long, Map<Long, AssessmentResult>> userAssessmentsResult;

    public AssessmentServiceImpl() {
        this.userAssessments = new ConcurrentHashMap<>();
        this.allAssessments = new ConcurrentHashMap<>();
        this.userAssessmentsResult = new ConcurrentHashMap<>();

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

        List<Question> qBlock3 = new ArrayList<>();
        qBlock3.add(new Question()
                .withId(1L)
                .withValue("Наша организация использует данные, чтобы определить, выполняются ли наши стратегические инициативы")
        );
        qBlock3.add(new Question()
                .withId(2L)
                .withValue("Наши данные являются точными, доступными и актуальными и используются для принятия обоснованных бизнес-решений)")
        );
        qBlock3.add(new Question()
                .withId(3L)
                .withValue("Наша система управления предназначена для постоянного улучшения наших продуктов и услуг.")
        );
        qBlock3.add(new Question()
                .withId(4L)
                .withValue("Процессы по выявлению и разрешению жалоб клиентов в нашей организации эффективны")
        );
        qBlock3.add(new Question()
                .withId(5L)
                .withValue("Наша организация понимает и может измерить влияние добавляющих и не добавляющих ценность активов")
        );

        List<Question> qBlock4 = new ArrayList<>();
        qBlock4.add(new Question()
                .withId(1L)
                .withValue("Наши бизнес-процессы четко определены, регулярно оцениваются, измеряются и постоянно совершенствуются")
        );
        qBlock4.add(new Question()
                .withId(2L)
                .withValue("Наша организация использует уроки, извлеченные из работы с клиентами, и переводит их в " +
                        "качестве материалов при разработке новых продуктов / услуг или новых процессов")
        );
        qBlock4.add(new Question()
                .withId(3L)
                .withValue("Наше  руководство помогает организации знать, что нужно знать, чтобы быть успешным")
        );
        qBlock4.add(new Question()
                .withId(4L)
                .withValue("Наша организация опирается на формальные методы повышения эффективности решения бизнес-задач")
        );

        List<Question> qBlock5 = new ArrayList<>();
        qBlock5.add(new Question()
                .withId(1L)
                .withValue("Наша организация стремится предоставить нашим сотрудникам возможность оспаривать статус-кво и улучшать способы работы")
        );
        qBlock5.add(new Question()
                .withId(2L)
                .withValue("Наше руководство является примером культуры и задает тон организации")
        );
        qBlock5.add(new Question()
                .withId(3L)
                .withValue("Вклад сотрудников в инновации и совершенствование признается и вознаграждается")
        );
        qBlock5.add(new Question()
                .withId(4L)
                .withValue("Наша организация полагает, что изменения возможны,  и поощряет людей к усилиям по совершенствованию организации")
        );
        qBlock5.add(new Question()
                .withId(5L)
                .withValue("Неудача рассматривается как способ учиться и расти")
        );


        List<Question> qBlock6 = new ArrayList<>();
        qBlock6.add(new Question()
                .withId(1L)
                .withValue("Наша организация имеет методы оценки наших поставщиков")
        );
        qBlock6.add(new Question()
                .withId(2L)
                .withValue("Наша организация сертифицирует и поддерживает их работу")
        );
        qBlock6.add(new Question()
                .withId(3L)
                .withValue("Проблемы отслеживаются и постоянно исправляются")
        );
        qBlock6.add(new Question()
                .withId(4L)
                .withValue("Мы проводим инициативы по улучшению с нашими поставщиками")
        );

        List<Question> qBlock7 = new ArrayList<>();
        qBlock7.add(new Question()
                .withId(1L)
                .withValue("Наша организация может измерить и увидеть влияние методов по улучшению")
        );
        qBlock7.add(new Question()
                .withId(2L)
                .withValue("Наша организация может определить ключевые тенденции в отношении опыта, " +
                        "удовлетворенности и лояльности клиентов")
        );
        qBlock7.add(new Question()
                .withId(3L)
                .withValue("Наша организация может отслеживать производительность в ключевых функциях, " +
                        "сравнивать их с применимыми критериями и двигаться в правильном направлении")
        );
        qBlock7.add(new Question()
                .withId(4L)
                .withValue("Наша организация может поддерживать деятельность по совершенствованию с течением времени")
        );
        qBlock7.add(new Question()
                .withId(5L)
                .withValue("Наша организация способна рассчитывать возврат инвестиций в различные усилия по постоянному совершенствованию")
        );
        qBlock7.add(new Question()
                .withId(6L)
                .withValue("Наша организация может определить свой успех в достижении  стратегических и финансовых целей")
        );



        List<QuestionBlock> questionBlocks = new ArrayList<>();
        questionBlocks.add(
                new QuestionBlock()
                        .withBlock(
                                new Block()
                                        .withName("Стратегическое планирование и развитие")
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

        questionBlocks.add(
                new QuestionBlock()
                        .withBlock(
                                new Block()
                                        .withName("Организация контроля и анализа")
                                        .withQuestions(qBlock3)
                                        .withRecommendations(Collections.emptyList())
                        )
        );

        questionBlocks.add(
                new QuestionBlock()
                        .withBlock(
                                new Block()
                                        .withName("Производительность и эффективность процессов")
                                        .withQuestions(qBlock4)
                                        .withRecommendations(Collections.emptyList())
                        )
        );

        questionBlocks.add(
                new QuestionBlock()
                        .withBlock(
                                new Block()
                                        .withName("Вовлеченность персонала и корпоративная культура")
                                        .withQuestions(qBlock5)
                                        .withRecommendations(Collections.emptyList())
                        )
        );

        questionBlocks.add(
                new QuestionBlock()
                        .withBlock(
                                new Block()
                                        .withName("Взаимодействие с контрагентами")
                                        .withQuestions(qBlock6)
                                        .withRecommendations(Collections.emptyList())
                        )
        );

        questionBlocks.add(
                new QuestionBlock()
                        .withBlock(
                                new Block()
                                        .withName("Итоговые показатели и результаты")
                                        .withQuestions(qBlock7)
                                        .withRecommendations(Collections.emptyList())
                        )
        );

        /* Global recommendations */


        GlobalRecommendation level1 = new GlobalRecommendation().withMinValue(35).withMaxValue(49)
                .withDescription("Основываясь на вашей оценке, Организация имеет начало систематического подхода к повышению эффективности работы. Как правило, она реагируют на проблемы, но не аналитически идентифицирует их, организация на начале пути к более активному решению проблем, используя подход. В развертывании имеется много основных пробелов. Могут быть определенные области бизнеса, использующие системный подход к развертыванию передового опыта. Существует рудиментарная система измерения, и данные не сообщаются для большинства ключевых областей бизнеса. Там, где сообщается об ограниченных позитивных тенденциях и результатах");
        GlobalRecommendation level2 = new GlobalRecommendation().withMinValue(50).withMaxValue(74)
                .withDescription("Основываясь на вашей оценке, Организация придерживается систематического подхода к повышению производительности, уделяя особое внимание профилактике. Не существует систем оценки или усовершенствования. Организация обычно реагирует на проблемы и не анализирует их идентификацию. Определяются приоритеты, но нет доказательств того, откуда они были разработаны. Организация начинает двигаться к более активному решению проблемы. В развертывании есть несколько основных пробелов. Многие области или рабочие подразделения находятся на ранних стадиях развития. Может быть одна область бизнеса, «стоящая во главе», использующая системный подход к развертыванию передового опыта. Данные представлены во многих ключевых областях бизнеса. Там, где это сообщается, в целом есть положительные тенденции и результаты.");
        GlobalRecommendation level3 = new GlobalRecommendation().withMinValue(75).withMaxValue(99)
                .withDescription("Основываясь на вашей оценке, Организация имеет надежную основанную на фактах систему предупреждения в ключевых областях. Не существует систем оценки или усовершенствования. Организация обычно реагирует на проблемы и не анализирует их идентификацию. Определяются приоритеты, но нет доказательств того, откуда они были разработаны. Организация начинает двигаться к более активному решению проблемы. В развертывании нет существенных пробелов. Многие области или рабочие подразделения находятся на ранних стадиях развития. Может быть одна область бизнеса, «стоящая во главе», использующая системный подход к развертыванию передового опыта. Данные представлены во многих ключевых областях бизнеса. Там, где это сообщается, в целом есть положительные тенденции и результаты. Некоторые из этих «трендовых индикаторов» оцениваются по сравнению с эталонами или другими отраслевыми сопоставлениями.");
        GlobalRecommendation level4 = new GlobalRecommendation().withMinValue(100).withMaxValue(124)
                .withDescription("Основываясь на вашей оценке, Организация имеет надежную и основанную на фактах систему предупреждения в ключевых областях. Существует множество циклов оценки и улучшения. Хорошо развернутая система производительности на месте. Многие области и рабочие единицы находятся на продвинутой стадии развития. Существует базовая система для определения целей и расстановки приоритетов на основе данных и анализа. Существует хорошее проактивное стандартизование проблемы, использующее подход. В развертывании есть только небольшие пробелы. Существует базовый скоординированный подход, основанный на развертывании передового опыта. Данные предоставляются для всех ключевых областей бизнеса. Там, где сообщается, есть хорошие тенденции улучшения (без каких-либо неблагоприятных тенденций) и результаты во всех ключевых областях бизнеса. Многие из этих «трендовых индикаторов» оцениваются по сравнению с эталонами или другими отраслевыми сопоставлениями.");
        GlobalRecommendation level5 = new GlobalRecommendation().withMinValue(125).withMaxValue(149)
                .withDescription("На основе вашей оценки Организация имеет интегрированную и основанную на фактах систему, действующую во всех областях. Существует множество циклов оценки и улучшения с существенными инновационными уточнениями. Хорошо развернутая система производительности на месте. Большинство областей и рабочих единиц находятся на продвинутой стадии развития. Существует усовершенствованная система для определения и определения приоритетов целей на основе данных и анализа. Существует стандартизированный и упреждающий подход к решению проблемы. В развертывании нет пробелов. Существует координированный корпоративный подход к развертыванию передового опыта. Данные представлены для всех ключевых областей бизнеса. Имеются устойчивые положительные тенденции и отличные результаты во всех ключевых областях бизнеса. Большинство тенденций оцениваются по сравнению с сравнительными показателями или другими отраслевыми сопоставлениями. В некоторых областях есть некоторые свидетельства контрольного лидерства.");
        GlobalRecommendation level6 = new GlobalRecommendation().withMinValue(150).withMaxValue(200)
                .withDescription("Основываясь на вашей оценке, у Организации есть сильная, интегрированная и основанная на фактах система, действующая во всех областях. Эта система рассматривается как инструмент управления ключами и часть корпоративной культуры. Существует множество циклов оценки и улучшения с существенными инновационными уточнениями. Полностью развернуто без разрывов развертывания. Все области и рабочие подразделения находятся на продвинутой стадии развития. Существует усовершенствованная система для определения целей и расстановки приоритетов на основе данных и анализа. Существует стандартизированный и упреждающий подход к решению проблемы, который используется в повседневной работе. Существует координированный корпоративный подход к развертыванию передового опыта. Данные представлены для всех ключевых областей бизнеса. Существуют сильные, устойчивые положительные тенденции и отличные результаты во всех ключевых областях бизнеса. Сильные свидетельства лидерства в большинстве областей.");

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
        assessmentId3.setGlobalRecommendations(Arrays.asList(level1, level2, level3, level4, level5, level6));

        /* Test assessment */
        List<QuestionBlock> testQuestionBlocks = new ArrayList<>();
        testQuestionBlocks.add(
                new QuestionBlock()
                        .withBlock(
                                new Block()
                                        .withName("Стратегическое планирование и развитие")
                                        .withQuestions(qBlock1)
                                        .withRecommendations(Collections.emptyList())
                        )
        );
        testQuestionBlocks.add(
                new QuestionBlock()
                        .withBlock(
                                new Block()
                                        .withName("Управление качеством")
                                        .withQuestions(qBlock2)
                                        .withRecommendations(Collections.emptyList())
                        )
        );

        GlobalRecommendation level11 = new GlobalRecommendation().withMinValue(10).withMaxValue(30)
                .withDescription("Основываясь на вашей оценке, Организация имеет начало систематического подхода к повышению эффективности работы. Как правило, она реагируют на проблемы, но не аналитически идентифицирует их, организация на начале пути к более активному решению проблем, используя подход. В развертывании имеется много основных пробелов. Могут быть определенные области бизнеса, использующие системный подход к развертыванию передового опыта. Существует рудиментарная система измерения, и данные не сообщаются для большинства ключевых областей бизнеса. Там, где сообщается об ограниченных позитивных тенденциях и результатах");
        GlobalRecommendation level21 = new GlobalRecommendation().withMinValue(31).withMaxValue(50)
                .withDescription("Основываясь на вашей оценке, Организация придерживается систематического подхода к повышению производительности, уделяя особое внимание профилактике. Не существует систем оценки или усовершенствования. Организация обычно реагирует на проблемы и не анализирует их идентификацию. Определяются приоритеты, но нет доказательств того, откуда они были разработаны. Организация начинает двигаться к более активному решению проблемы. В развертывании есть несколько основных пробелов. Многие области или рабочие подразделения находятся на ранних стадиях развития. Может быть одна область бизнеса, «стоящая во главе», использующая системный подход к развертыванию передового опыта. Данные представлены во многих ключевых областях бизнеса. Там, где это сообщается, в целом есть положительные тенденции и результаты.");


        Assessment assessmentId2 = new Assessment();
        Long secondId = currentId.incrementAndGet();
        assessmentId2.setId(secondId);
        assessmentId2.setName("Тестовая оценка");
        assessmentId2.withStatus("Новая");
        assessmentId2.setComment("");
        assessmentId2.setUserId(1L);
        assessmentId2.setCompanyTypeId(2);
        assessmentId2.setIndustryId(2);
        assessmentId2.setDescription("Тестовая оценка");
        assessmentId2.setStatus("Активная");
        assessmentId2.setQuestionBlocks(testQuestionBlocks);
        assessmentId2.setGlobalRecommendations(Arrays.asList(level11, level21));



        userAssessments.put(secondId, assessmentId2);
        userAssessments.put(thirdId, assessmentId3);

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
    public void addAssessmentResult(Long userId, AssessmentResult result) {
        result.setCreateDate(Date.from(Instant.now()).getTime());
        Map<Long, AssessmentResult> userResults = userAssessmentsResult.getOrDefault(userId, new HashMap<>());
        if (!userResults.isEmpty()){
            userResults.put(currentAssessmentResultId.getAndIncrement(), result);
        } else {
            userResults.put(currentAssessmentResultId.getAndIncrement(), result);
            userAssessmentsResult.put(userId, userResults);
        }
    }

    @Override
    public List<AssessmentResult> getAssessmentsResult(Long userId) {
        List<AssessmentResult> assessmentsResult = new ArrayList<>();
        userAssessmentsResult
                .getOrDefault(userId, new HashMap<>())
                .forEach((key, value) -> assessmentsResult.add(value));
        return assessmentsResult;
    }

}
