package com.projeto.barbearia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@EntityScan(basePackages = BarbeariaApplication.PACOTE_MODELO)
@EnableJpaRepositories(BarbeariaApplication.BASE_REPOSITORY)
@EnableScheduling
@SpringBootApplication
public class BarbeariaApplication {

	public static final String BASE_REPOSITORY = "com.projeto.barbearia";
	public static final String PACOTE_MODELO = "com.projeto.barbearia";

	public static void main(String[] args) {
		SpringApplication.run(BarbeariaApplication.class, args);
	}

}
