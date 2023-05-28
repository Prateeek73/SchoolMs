package com.apps.studentms;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.apps.studentms.dao.StudentRepositoryImpl;
import com.apps.studentms.service.StudentServiceImpl;

@Configuration
public class AppConfig {
    
    @Bean(name = "studentService")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public StudentServiceImpl getStudentService(){

        // constructor injection
        return new StudentServiceImpl(getStudentRepository());

        // setter injection
        // StudentServiceImpl service = new StudentServiceImpl();
        // service.setRepository(getStudentRepository());
        // return service;
        
    }

    @Bean(name = "studentRepository")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public StudentRepositoryImpl getStudentRepository(){
        return new StudentRepositoryImpl();
    }

}
