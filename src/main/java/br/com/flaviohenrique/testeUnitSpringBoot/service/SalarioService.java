package br.com.flaviohenrique.testeUnitSpringBoot.service;

import org.springframework.stereotype.Service;

import br.com.flaviohenrique.testeUnitSpringBoot.domian.Funcionario;

@Service
public class SalarioService {

//	public double calculaSalarioDesconto(Funcionario funcionario) {
//		if (funcionario.getCargo().equals(Cargos.DESENVOLVEDOR)) {
//			if (funcionario.getSalario() > 3000) {
//				return funcionario.getSalario() * 0.8;
//			}
//			return funcionario.getSalario() * 0.9;
//		}else 
//			if(funcionario.getSalario() > 2500) {
//			return funcionario.getSalario() * 0.75;
//		}
//		return funcionario.getSalario() * 0.85;
//	}
	
	public double calculaSalarioDesconto(Funcionario funcionario) {
		return funcionario.getCargo().getCalculoSalario().regras(funcionario);
	}
}
