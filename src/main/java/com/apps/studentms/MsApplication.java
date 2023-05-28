package com.apps.studentms;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apps.studentms.frontend.ConsoleFront;

public class MsApplication {
	
	public static void main(String[] args) {
		ApplicationContext  appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ConsoleFront console = new ConsoleFront(appContext);
		console.runUI();
	}
}
