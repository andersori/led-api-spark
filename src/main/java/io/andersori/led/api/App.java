package io.andersori.led.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.andersori.led.api.bean.MarathonBean;
import io.andersori.led.api.bean.ParticipantTeamBean;
import io.andersori.led.api.bean.SemesterBean;
import io.andersori.led.api.bean.TeamBean;
import io.andersori.led.api.bean.UserLedBean;
import io.andersori.led.api.entity.RoleLed;
import io.andersori.led.api.service.MarathonServiceIm;
import io.andersori.led.api.service.MarathonServiceIn;
import io.andersori.led.api.service.ParticipantTeamServiceIm;
import io.andersori.led.api.service.ParticipantTeamServiceIn;
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
		bean1.setName("Temp");
		bean1.setPassword(BCrypt.hashpw("1234", BCrypt.gensalt()));
		bean1.setUsername("team");
		bean1.setRoles(new HashSet<RoleLed>(Arrays.asList(RoleLed.STUDENT)));

		ser.register(bean);
		ser.register(bean1);
	}

	public static void teamCreate() {
		UserServiceIn serUsers = BeanUtil.getBean(UserServiceIm.class);
		TeamServiceIn serTeam = BeanUtil.getBean(TeamServiceIm.class);

		TeamBean bean2 = new TeamBean();
		bean2.setUser(serUsers.get(2L).get());

		serTeam.register(bean2);
	}

	public static void createMarathon() {
		MarathonBean mar = new MarathonBean();
		SemesterBean ses = new SemesterBean();
		ses.setNumberSemester(2);
		ses.setYear(2019);

		mar.setDate(LocalDate.now());
		mar.setSemester(ses);
		
		MarathonServiceIn marService = BeanUtil.getBean(MarathonServiceIm.class);
		marService.register(mar);

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
	
}
