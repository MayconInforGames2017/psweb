package br.com.pswmaycon.empregado.model.service;

import java.util.Arrays;
import java.util.List;

import br.com.pswmaycon.empregado.model.Empregado;

public class EmpregadoService {
	
	public List<Empregado> getEmprego() {
		return Arrays.asList(new Empregado(1, "Maycon", "Santana"), 
				new Empregado(2, "Tony", "Stark"));
	}

}
