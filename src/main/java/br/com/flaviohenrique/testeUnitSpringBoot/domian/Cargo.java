package br.com.flaviohenrique.testeUnitSpringBoot.domian;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Cargo {

	private RegrasCalculoSalario calculoSalario;
	
	
	public Cargo(RegrasCalculoSalario calculoSalario) {
		this.calculoSalario = calculoSalario;
	}
	
	public Cargo getDESENVOLVEDOR() {
		return new Cargo(new DezOuVintePorCento());
	}
	public Cargo getDBA() {
		return new Cargo(new QuinzeOuVinteCincoPorCento());
	}
	public Cargo getTESTADOR() {
		return new Cargo(new QuinzeOuVinteCincoPorCento());
	}


	public RegrasCalculoSalario getCalculoSalario() {
		return calculoSalario;
	}


	public void setCalculoSalario(RegrasCalculoSalario calculoSalario) {
		this.calculoSalario = calculoSalario;
	}
	
	
	
}
