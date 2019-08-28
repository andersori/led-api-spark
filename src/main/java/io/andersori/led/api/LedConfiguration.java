package io.andersori.led.api;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.andersori.led.api.entity.Course;
import io.andersori.led.api.entity.Marathon;
import io.andersori.led.api.entity.ParticipantTeam;
import io.andersori.led.api.entity.SchoolClass;
import io.andersori.led.api.entity.Student;
import io.andersori.led.api.entity.Team;
import io.andersori.led.api.entity.UserLed;

@Configuration
@ComponentScan("io.andersori.led.api")
public class LedConfiguration {
				
	@Bean(name = "SessionFactory")
	public SessionFactory getSessionFactory() {
		try {
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
			
	        Map<String, String> settings = new HashMap<String, String>();
	        
	        settings.put(Environment.DRIVER, "org.h2.Driver");
	        settings.put(Environment.URL, "jdbc:h2:mem:testdb");
	        settings.put(Environment.USER, "sa");
	        settings.put(Environment.PASS, "sa");
	        settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
	        settings.put(Environment.SHOW_SQL, "false");
	        settings.put(Environment.HBM2DDL_AUTO, "create");
	        settings.put(Environment.POOL_SIZE, "10");
	        settings.put(Environment.NON_CONTEXTUAL_LOB_CREATION, "true");
	
	        registryBuilder.applySettings(settings);
	
	        StandardServiceRegistry registry = registryBuilder.build();
	
	        MetadataSources sources = new MetadataSources(registry)
											.addAnnotatedClass(Course.class)
											.addAnnotatedClass(Marathon.class)
											.addAnnotatedClass(ParticipantTeam.class)
											.addAnnotatedClass(SchoolClass.class)
											.addAnnotatedClass(Student.class)
											.addAnnotatedClass(Team.class)
											.addAnnotatedClass(UserLed.class);
	                                        
	        Metadata metadata = sources.getMetadataBuilder().build();
	        
	        return metadata.getSessionFactoryBuilder().build();
	    } catch(Throwable e){
	        throw new ExceptionInInitializerError(e);
	    }
	}

}
