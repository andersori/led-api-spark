package io.andersori.led.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.andersori.led.api.bean.UserLedBean;
import io.andersori.led.api.controller.CourseController;
import io.andersori.led.api.controller.MarathonController;
import io.andersori.led.api.controller.ParticipantTeamController;
import io.andersori.led.api.controller.SchoolClassController;
import io.andersori.led.api.controller.SemesterController;
import io.andersori.led.api.controller.StudentController;
import io.andersori.led.api.controller.TeamController;
import io.andersori.led.api.controller.UserController;
import io.andersori.led.api.service.UserServiceIm;
import io.andersori.led.api.service.UserServiceIn;
import io.andersori.led.api.util.BeanUtil;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(LedConfiguration.class);
		
		userRegister();

		//Routers
		new CourseController();
		new MarathonController();
		new ParticipantTeamController();
		new SchoolClassController();
		new SemesterController();
		new StudentController();
		new TeamController();
		new UserController();

		//Close context
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			((ConfigurableApplicationContext)context).close();
		}));
		
	}

	private static void userRegister() {
		UserServiceIn ser = BeanUtil.getBean(UserServiceIm.class);
		
		UserLedBean bean = new UserLedBean();
		bean.setName("Anderson");
		bean.setPassword("123");
		bean.setUsername("andersori");

		ser.register(bean);
	}
	
}
