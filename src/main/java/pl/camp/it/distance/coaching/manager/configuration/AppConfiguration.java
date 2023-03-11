package pl.camp.it.distance.coaching.manager.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("pl.camp.it.distance.coaching.manager")
@EnableScheduling
public class AppConfiguration {
    @Bean
    public SessionFactory sessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }
}
