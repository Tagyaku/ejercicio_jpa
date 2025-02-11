package es.cursosprhib.spr01xml;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.cursosprhib.spr01xml.servicios.ServicioPrincipal;

public class Test02 {
	public static void main(String[] args) {
		
		BeanFactory ctx = new ClassPathXmlApplicationContext("a02appcontext.xml");
		
		ServicioPrincipal sp = ctx.getBean("sPrincipal", ServicioPrincipal.class);
		sp.metodoServicio();
		
	}
}
