package io.andersori.led.api;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.andersori.led.api.bean.CourseBean;
import io.andersori.led.api.bean.MarathonBean;
import io.andersori.led.api.bean.ParticipantTeamBean;
import io.andersori.led.api.bean.SchoolClassBean;
import io.andersori.led.api.bean.SemesterBean;
import io.andersori.led.api.bean.StudentBean;
import io.andersori.led.api.bean.TeamBean;
import io.andersori.led.api.bean.UserLedBean;
import io.andersori.led.api.entity.RoleLed;
import io.andersori.led.api.service.CourseServiceIm;
import io.andersori.led.api.service.CourseServiceIn;
import io.andersori.led.api.service.MarathonServiceIm;
import io.andersori.led.api.service.MarathonServiceIn;
import io.andersori.led.api.service.ParticipantTeamServiceIm;
import io.andersori.led.api.service.ParticipantTeamServiceIn;
import io.andersori.led.api.service.SchoolClassServiceIm;
import io.andersori.led.api.service.SchoolClassServiceIn;
import io.andersori.led.api.service.TeamServiceIm;
import io.andersori.led.api.service.TeamServiceIn;
import io.andersori.led.api.service.UserServiceIm;
import io.andersori.led.api.service.UserServiceIn;
import io.andersori.led.api.util.BeanUtil;
import spark.Spark;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(LedConfiguration.class);
		
		userRegister();
		teamCreate();
		createMarathon();
		createParticipants();

		Spark.get("/", (req, res) -> {
			return "Working";
		});

		//Close context
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			((ConfigurableApplicationContext)context).close();
		}));
		
	}

	private static void userRegister() {
		UserServiceIn ser = BeanUtil.getBean(UserServiceIm.class);
		
		UserLedBean bean = new UserLedBean();
		bean.setName("Soriano");
		bean.setPassword(BCrypt.hashpw("1234", BCrypt.gensalt()));
		bean.setUsername("andersori");
		bean.setRoles(new HashSet<RoleLed>(Arrays.asList(RoleLed.ADMIN, RoleLed.STUDENT)));

		UserLedBean bean1 = new UserLedBean();
		bean1.setName("Equipe_1");
		bean1.setPassword(BCrypt.hashpw("1234", BCrypt.gensalt()));
		bean1.setUsername("team1");
		bean1.setRoles(new HashSet<RoleLed>(Arrays.asList(RoleLed.STUDENT)));

		UserLedBean bean2 = new UserLedBean();
		bean2.setName("Equipe_2");
		bean2.setPassword(BCrypt.hashpw("1234", BCrypt.gensalt()));
		bean2.setUsername("team2");
		bean2.setRoles(new HashSet<RoleLed>(Arrays.asList(RoleLed.STUDENT)));

		UserLedBean bean3 = new UserLedBean();
		bean3.setName("Equipe_3");
		bean3.setPassword(BCrypt.hashpw("1234", BCrypt.gensalt()));
		bean3.setUsername("team3");
		bean3.setRoles(new HashSet<RoleLed>(Arrays.asList(RoleLed.STUDENT)));

		ser.register(bean);
		ser.register(bean1);
		ser.register(bean2);
		ser.register(bean3);
	}

	public static void teamCreate() {
		UserServiceIn serUsers = BeanUtil.getBean(UserServiceIm.class);
		TeamServiceIn serTeam = BeanUtil.getBean(TeamServiceIm.class);

		TeamBean bean2 = new TeamBean();
		bean2.setUser(serUsers.get(2L).get());

		serTeam.register(bean2);
	}

	public static void createMarathon() {
		MarathonBean mar1 = new MarathonBean();
		MarathonBean mar2 = new MarathonBean();

		SemesterBean ses = new SemesterBean();
		ses.setNumberSemester(2);
		ses.setYear(2019);

		mar1.setDate(LocalDate.now());
		mar1.setSemester(ses);

		mar2.setDate(LocalDate.of(2019, 10, 1));
		mar2.setSemester(ses);
		
		MarathonServiceIn marService = BeanUtil.getBean(MarathonServiceIm.class);
		marService.register(mar1);
		marService.register(mar2);

	}

	public static void createParticipants() {
		ParticipantTeamServiceIn parService = BeanUtil.getBean(ParticipantTeamServiceIm.class);
		MarathonServiceIn marService = BeanUtil.getBean(MarathonServiceIm.class);
		TeamServiceIn teamService = BeanUtil.getBean(TeamServiceIm.class);

		MarathonBean marBean = marService.get(1L).get();
		TeamBean teamBean = teamService.get(1L).get();

		ParticipantTeamBean part1 = new ParticipantTeamBean();
		part1.setMarathon(marBean);
		part1.setTeam(teamBean);

		parService.register(part1);
	}

	public static void createCourses() {
		CourseBean curso1 = new CourseBean();
		curso1.setName("Engenharia de Software");
		SchoolClassBean turma1 = new SchoolClassBean();
		turma1.setCodClass("8jdjdl2");
		turma1.setName("Estrutura de Dados");
		SemesterBean ses = new SemesterBean();
		ses.setNumberSemester(2);
		ses.setYear(2019);
		turma1.setSemester(ses);
		turma1.setCourse(curso1);
		curso1.setSchoolClasses(Arrays.asList(turma1));

		SchoolClassServiceIn schoolSer = BeanUtil.getBean(SchoolClassServiceIm.class);
		CourseServiceIn courseSer = BeanUtil.getBean(CourseServiceIm.class);

		schoolSer.register(turma1);
		courseSer.register(curso1);

	}
	
	public static void createStudents() {
		StudentBean bean1 = new StudentBean();
		StudentBean bean2 = new StudentBean();
		StudentBean bean3 = new StudentBean();
		StudentBean bean4 = new StudentBean();

		bean1.setName("temp1");
		bean2.setName("team2");
		bean3.setName("team3");
		bean4.setName("team4");

		bean1.setRegistration(111111L);
		bean2.setRegistration(444444L);
		bean3.setRegistration(555555L);
		bean4.setRegistration(666666L);

	}
}
