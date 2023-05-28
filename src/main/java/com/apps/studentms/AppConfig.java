package com.apps.studentms;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"com.studentms"})
public class AppConfig {

    /*
    // Spring Configuration without Autowiring
        @Bean(name = "studentService")
        @Scope(value = BeanDefinition.SCOPE_SINGLETON)
        public StudentServiceImpl getStudentService(){

            // constructor injection
            return new StudentServiceImpl(getStudentRepository());

            // setter injection
            StudentServiceImpl service = new StudentServiceImpl();
            service.setRepository(getStudentRepository());
            return service;
            
        }

        @Bean(name = "studentRepository")
        @Scope(value = BeanDefinition.SCOPE_SINGLETON)
        public StudentRepositoryImpl getStudentRepository(){
            return new StudentRepositoryImpl();
        }

        */

}
