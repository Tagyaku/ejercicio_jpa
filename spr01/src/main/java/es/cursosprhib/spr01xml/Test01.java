package es.cursosprhib.spr01xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.cursosprhib.spr01xml.servicios.Servicio01;

public class Test01 {

	public static void main(String[] args) {
		
		
		BeanFactory ctx = new ClassPathXmlApplicationContext("a01appcontext.xml");
		
//		Servicio01 s = ctx.getBean("s01", Servicio01.class);
//		s.m1();
//		s.setDescripcion("mi primer bean");
		
		
		Servicio01 sNuevo = ctx.getBean("s01", Servicio01.class);
		System.out.println(sNuevo.getDescripcion());
		
	}
}
