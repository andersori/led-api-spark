package io.andersori.led.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfiguration.class);
		System.out.println(context.containsBean("UserRepository"));
		
	}
	
}
