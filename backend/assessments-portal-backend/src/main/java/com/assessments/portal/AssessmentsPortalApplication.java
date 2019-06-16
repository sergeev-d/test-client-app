package com.assessments.portal;

import com.assessments.portal.web.domain.assessment.*;
import com.assessments.portal.web.domain.user.User;
import com.assessments.portal.web.repository.AssessmentRepository;
import com.assessments.portal.web.repository.UserRepository;
import com.assessments.portal.web.services.AssessmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.Instant;
import java.util.*;

@SpringBootApplication
@EnableWebMvc
public class AssessmentsPortalApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AssessmentRepository assessmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(AssessmentsPortalApplication.class, args);
//		todo check that https://github.com/hantsy/springboot-jwt-sample/tree/master/src/main/java/com/example/demo/web
//		https://github.com/jwtk/jjwt
// 		axios interceptor https://github.com/alexatiks/spring-security-jwt-csrf/blob/master/frontend/src/main.js
//https://spring.io/guides/tutorials/spring-security-and-angular-js/
		//https://github.com/naturalprogrammer/spring-lemon/tree/master/spring-lemon-commons-web/src/main
		//https://github.com/taskagile/vuejs.spring-boot.mysql

	}

	@Override
	public void run(String... args) throws Exception {
		/* add users */
		final User expertUser = User.create(1L, 1, "ivanov-i", "11111111", "79000000000", "expert@mail.ru",
				"Иван", "Иванов", null, "ИП Корпоративные оценки", Date.from(Instant.now()), null);

		final User clientUser = User.create(2L, 2, "alex-n", "22222222", "79000000001", "client@mail.ru",
				"Александр", "Николаевич", null, "Рога и копыта", Date.from(Instant.now()), null);
		userRepository.save(expertUser);
		userRepository.save(clientUser);

		/* add assessments */
		/* Productive assessment */
		final List<Question> qBlock1 = new ArrayList<>();
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

		final List<Question> qBlock2 = new ArrayList<>();
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

		final List<Question> qBlock3 = new ArrayList<>();
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

		final List<Question> qBlock4 = new ArrayList<>();
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

		final List<Question> qBlock5 = new ArrayList<>();
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


		final List<Question> qBlock6 = new ArrayList<>();
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

		final List<Question> qBlock7 = new ArrayList<>();
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

		final List<QuestionBlock> questionBlocks = new ArrayList<>();
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


		final Context context = new Context()
				.withQuestions(questionBlocks)
				.withGlobalRecommendations(Arrays.asList(level1, level2, level3, level4, level5, level6));

		ObjectMapper mapper = new ObjectMapper();
		String contextAsString = mapper.writeValueAsString(context);

		AssessmentDAO prodAssessment = AssessmentDAO.create("Продуктивная оценка", "Продуктивная оценка", AssessmentStatus.ACTIVE.getStatus(), "",
				2, 2, 1L, Date.from(Instant.now()), null, contextAsString);
		assessmentRepository.save(prodAssessment);
	}
}
