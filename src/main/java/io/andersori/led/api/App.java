package io.andersori.led.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.andersori.led.api.bean.UserLedBean;
import io.andersori.led.api.controller.UserController;
import io.andersori.led.api.service.UserServiceIm;
import io.andersori.led.api.service.UserServiceIn;
import io.andersori.led.api.util.BeanUtil;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(LedConfiguration.class);
		
		userRegister();

		//Routers
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

	private static void marathonRegister() { 

	}
}
