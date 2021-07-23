package br.com.pswmaycon.empregado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import br.com.pswmaycon.empregado.model.servlet.EmpregadoServlet;

@ServletComponentScan
@SpringBootApplication
public class CrudEmpregadoApplication {
	
	@Bean
	public EmpregadoServlet servlet() {
		return new EmpregadoServlet();
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudEmpregadoApplication.class, args);
	}

}
