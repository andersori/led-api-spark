package io.andersori.led.api;

import java.util.Arrays;
import java.util.HashSet;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.andersori.led.api.bean.TeamBean;
import io.andersori.led.api.bean.UserLedBean;
import io.andersori.led.api.entity.RoleLed;
import io.andersori.led.api.service.TeamServiceIm;
import io.andersori.led.api.service.TeamServiceIn;
import io.andersori.led.api.service.UserServiceIm;
import io.andersori.led.api.service.UserServiceIn;
import io.andersori.led.api.util.BeanUtil;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(LedConfiguration.class);
		
		userRegister();
		teamCreate();

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

		ser.register(bean);
	}

	public static void teamCreate() {
		UserServiceIn serUsers = BeanUtil.getBean(UserServiceIm.class);
		TeamServiceIn serTeam = BeanUtil.getBean(TeamServiceIm.class);

		UserLedBean bean = new UserLedBean();
		bean.setName("Temp");
		bean.setPassword(BCrypt.hashpw("1234", BCrypt.gensalt()));
		bean.setUsername("team");
		bean.setRoles(new HashSet<RoleLed>(Arrays.asList(RoleLed.STUDENT)));

		serUsers.register(bean);

		TeamBean bean2 = new TeamBean();
		bean2.setUser(serUsers.getUser(1L).get());

		serTeam.register(bean2);
	}
	
}
