package br.upe.progaramacaoweb.apiservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ApiServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiServletApplication.class, args);
	}

}