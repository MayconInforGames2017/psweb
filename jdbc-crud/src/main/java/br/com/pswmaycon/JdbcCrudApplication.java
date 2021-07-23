package br.com.pswmaycon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@ServletComponentScan
@SpringBootApplication
public class JdbcCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcCrudApplication.class, args);
	}

}
