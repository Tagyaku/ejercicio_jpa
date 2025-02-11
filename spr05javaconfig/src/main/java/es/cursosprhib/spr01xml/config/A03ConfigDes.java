package es.cursosprhib.spr01xml.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@Profile({"desarrollo","default"})
@PropertySource("classpath:app.properties")
public class A03ConfigDes {

	@Autowired
	Environment prop;
	
	
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl(prop.getProperty("bbdd.des.url"));
		bds.setDriverClassName(prop.getProperty("bbdd.des.driver"));
		bds.setUsername(prop.getProperty("bbdd.des.user"));
		bds.setPassword(prop.getProperty("bbdd.des.pwd"));
		return bds;
	}
	
}
