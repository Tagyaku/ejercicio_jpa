package es.cursosprhib.p01mdp_persistencia;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Configuration
public class EMFactory {
	private static EntityManagerFactory emf;
	
	
	private EMFactory() {}
	
	
	public static EntityManagerFactory getEmf() {
		if(emf == null) {
			Map<String, Object> prop = new HashMap<>();

			prop.put("javax.persistence.jdbc.user", "root");
			prop.put("javax.persistence.jdbc.password", "root");
			prop.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
			prop.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/medios_de_pago");
			prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

			emf = Persistence.createEntityManagerFactory("medios_de_pago", prop);
		}
		return emf;
	}
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return getEmf(); 
    }
}
