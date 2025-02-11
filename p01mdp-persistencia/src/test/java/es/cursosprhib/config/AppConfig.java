package es.cursosprhib.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import es.cursosprhib.p01mdp_persistencia.EMFactory;

@Configuration
@PropertySource("classpath:bbdd.properties")
@ComponentScan({"es.cursosprhib.vista","es.cursosprhib.mediosdepago.persistencia"})
@Import(EMFactory.class)
public class AppConfig {

	@Autowired
	Environment prop;
	

	
	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl(prop.getProperty("bbdd.url"));
		bds.setDriverClassName(prop.getProperty("bbdd.driver"));
		bds.setUsername(prop.getProperty("bbdd.user"));
		bds.setPassword(prop.getProperty("bbdd.pass"));
		return bds;
	}
	
	
	
}
