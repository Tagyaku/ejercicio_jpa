package es.cursosprhib.spr01xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.cursosprhib.spr01xml.servicios.ServicioConAccesoADatos;

public class Test03 {
	public static void main(String[] args) {
		
		BeanFactory ctx = new ClassPathXmlApplicationContext("a03appContext.xml");
		
		ServicioConAccesoADatos scio= ctx.getBean(ServicioConAccesoADatos.class);
		
		scio.realizarConsulta();
		
	}
}
