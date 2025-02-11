package es.cursosprhib.spr01xml;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.cursosprhib.spr01xml.config.A02Config;
import es.cursosprhib.spr01xml.servicios.ServicioPrincipal;

public class Test02 {
	public static void main(String[] args) {
		
		BeanFactory ctx = new AnnotationConfigApplicationContext(A02Config.class);
		
		ServicioPrincipal sp = ctx.getBean("sPrincipal", ServicioPrincipal.class);
		sp.metodoServicio();
		
	}
}
