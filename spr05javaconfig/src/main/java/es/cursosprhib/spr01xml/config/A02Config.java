package es.cursosprhib.spr01xml.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.cursosprhib.spr01xml.servicios.Servicio01;
import es.cursosprhib.spr01xml.servicios.Servicio01Impl;
import es.cursosprhib.spr01xml.servicios.ServicioPrincipal;

@Configuration
public class A02Config {

	
	@Bean(name = "s01")
	public Servicio01Impl s01() {
		return new Servicio01Impl("inicializado");
	}
	@Bean(name = "s02")
	public Servicio01Impl s02() {
		return new Servicio01Impl("inicializado 2");
	}
	
	@Bean()
	public ServicioPrincipal sPrincipal(@Qualifier("s02") Servicio01 s01) {
		ServicioPrincipal sp = new ServicioPrincipal();
		sp.setDescripcion("servicio principal");
		sp.setS01(s01);
		return sp;
	}
	
	
}
