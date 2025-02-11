package es.cursosprhib.spr01xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.cursosprhib.spr01xml.servicios.Servicio01Impl;

@Configuration
public class A01Config {

	
	@Bean(name = "s01")
	public Servicio01Impl s01() {
		return new Servicio01Impl("inicializado");
	}
	
	
}
