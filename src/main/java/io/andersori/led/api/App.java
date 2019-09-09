package io.andersori.led.api;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.andersori.led.api.dto.MarathonDto;
import io.andersori.led.api.dto.ParticipantTeamDto;
import io.andersori.led.api.dto.SemesterDto;
import io.andersori.led.api.dto.TeamDto;
import io.andersori.led.api.dto.UserLedDto;
import io.andersori.led.api.entity.RoleLed;
import io.andersori.led.api.service.IMarathonService;
import io.andersori.led.api.service.IParticipantTeamService;
import io.andersori.led.api.service.ITeamService;
import io.andersori.led.api.service.IUserService;
import io.andersori.led.api.service.MarathonService;
import io.andersori.led.api.service.ParticipantTeamService;
import io.andersori.led.api.service.TeamService;
import io.andersori.led.api.service.UserService;
import io.andersori.led.api.util.BeanUtil;
import spark.Spark;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(LedConfiguration.class);
		
		userRegister();
		teamCreate();
		createMarathon();
		createParticipants();
		//createCourses();

		Spark.get("/", (req, res) -> {
			return "Working";
		});

		//Close context
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			((ConfigurableApplicationContext)context).close();
		}));
		
	}

	private static void userRegister() {
		IUserService ser = BeanUtil.getBean(UserService.class);
		
		UserLedDto bean = new UserLedDto();
		bean.setName("Soriano");
		bean.setPassword(BCrypt.hashpw("1234", BCrypt.gensalt()));
		bean.setUsername("andersori");
		bean.setRoles(new HashSet<RoleLed>(Arrays.asList(RoleLed.ADMIN, RoleLed.STUDENT)));

		UserLedDto bean1 = new UserLedDto();
		bean1.setName("Equipe_1");
		bean1.setPassword(BCrypt.hashpw("1234", BCrypt.gensalt()));
		bean1.setUsername("team1");
		bean1.setRoles(new HashSet<RoleLed>(Arrays.asList(RoleLed.STUDENT)));

		UserLedDto bean2 = new UserLedDto();
		bean2.setName("Equipe_2");
		bean2.setPassword(BCrypt.hashpw("1234", BCrypt.gensalt()));
		bean2.setUsername("team2");
		bean2.setRoles(new HashSet<RoleLed>(Arrays.asList(RoleLed.STUDENT)));

		UserLedDto bean3 = new UserLedDto();
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
		IUserService serUsers = BeanUtil.getBean(UserService.class);
		ITeamService serTeam = BeanUtil.getBean(TeamService.class);

		TeamDto bean2 = new TeamDto();
		bean2.setUser(serUsers.get(2L).get());

		serTeam.register(bean2);
	}

	
	public static void createMarathon() {
		MarathonDto mar1 = new MarathonDto();
		MarathonDto mar2 = new MarathonDto();

		SemesterDto ses = new SemesterDto();
		ses.setNumberSemester(2);
		ses.setYear(2019);

		mar1.setDate(LocalDate.now());
		mar1.setSemester(ses);

		mar2.setDate(LocalDate.of(2019, 10, 1));
		mar2.setSemester(ses);
		
		IMarathonService marService = BeanUtil.getBean(MarathonService.class);
		marService.register(mar1);
		marService.register(mar2);

	}

	public static void createParticipants() {
		IParticipantTeamService parService = BeanUtil.getBean(ParticipantTeamService.class);
		IMarathonService marService = BeanUtil.getBean(MarathonService.class);
		ITeamService teamService = BeanUtil.getBean(TeamService.class);

		MarathonDto marBean = marService.get(1L).get();
		TeamDto teamBean = teamService.get(1L).get();

		ParticipantTeamDto part1 = new ParticipantTeamDto();
		part1.setMarathon(marBean);
		part1.setTeam(teamBean);

		parService.register(part1);
	}
	/*
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
	*/
}
