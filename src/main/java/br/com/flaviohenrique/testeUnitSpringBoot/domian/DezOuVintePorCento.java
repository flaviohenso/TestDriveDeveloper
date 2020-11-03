package br.com.flaviohenrique.testeUnitSpringBoot.domian;

public class DezOuVintePorCento implements RegrasCalculoSalario {

	public Double regras(Funcionario funcionario) {
		
		if(funcionario.getSalario() > 3000) {
			return funcionario.getSalario() * 0.80;
		}
		
		return funcionario.getSalario() * 0.90;
	}

}
