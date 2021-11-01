package com.geoInfo.project;

import com.geoInfo.project.dao.IntermediaireRepository;
import com.geoInfo.project.model.Intermediaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {
	//main test comment

	@Autowired
	private IntermediaireRepository intermediaireRepository ;
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	public void run(String... args) throws Exception {

		intermediaireRepository.save(new Intermediaire(null,"user@gmail.com",
				"user","ROLE_USER","aa","aa","","","","","","","","","ROLE_INTER"));
		intermediaireRepository.save(new Intermediaire(null,"user2@gmail.com",
				"user","ROLE_USER","bb","","","","","","","","","","inter"));
		intermediaireRepository.save(new Intermediaire(null,"user3@gmail.com",
				"user","ROLE_USER","cc","","","","","","","","","","user"));
		intermediaireRepository.save(new Intermediaire(null,"user4@gmail.com",
				"user","ROLE_USER","dd","","","","","","","","","","user"));
		intermediaireRepository.findAll().forEach(System.out::println);



	}

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOriginPatterns(Arrays.asList("*"));
		config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "responseType", "Authorization"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
