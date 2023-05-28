package com.apps.studentms;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.apps.studentms.frontend.ConsoleFront;

public class MsApplication {
	
	public static void main(String[] args) {
		ApplicationContext  appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ConsoleFront console = new ConsoleFront(appContext);
		console.runUI();
	}

}
