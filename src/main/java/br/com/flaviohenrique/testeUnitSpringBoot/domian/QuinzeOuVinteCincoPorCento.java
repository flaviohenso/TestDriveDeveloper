package br.com.flaviohenrique.testeUnitSpringBoot.domian;

public class QuinzeOuVinteCincoPorCento implements RegrasCalculoSalario {

	public Double regras(Funcionario funcionario) {
		if(funcionario.getSalario() < 2500) {
			return funcionario.getSalario() * 0.85;
		}
		return funcionario.getSalario() * 0.75;
	}

}
