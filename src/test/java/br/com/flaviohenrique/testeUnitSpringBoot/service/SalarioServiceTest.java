package br.com.flaviohenrique.testeUnitSpringBoot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.flaviohenrique.testeUnitSpringBoot.domian.Cargo;
import br.com.flaviohenrique.testeUnitSpringBoot.domian.Funcionario;

@SpringBootTest
class SalarioServiceTest {

	SalarioService SalarioService = new SalarioService();

	/*
	 * O primeiro cenário a ser testado será o de desenvolvedores com salários menor
	 * do que R$3000,0. Sabemos que o desconto é de 10%. Portanto, se o
	 * desenvolvedor ganhar R$2500,00, seu salário menos desconto deve ser de R$
	 * 2250,00 (2500 * 90%):
	 */
	@Test
	final void calculaSalarioDescontoProgramadorMenorTresMillTest() {

		Funcionario funcionario = new Funcionario("Flávio", 2500.0, new Cargo().getDESENVOLVEDOR());
		double salarioCalculado = SalarioService.calculaSalarioDesconto(funcionario);
		assertEquals(funcionario.getSalario() * 0.9, salarioCalculado, 0.2);
		
	}

	/*
	 * O segundo cenário a ser testado será o de desenvolvedores com salários maior
	 * do que R$3000,0. Sabemos que o desconto é de 20%. Portanto, se o
	 * desenvolvedor ganhar R$3500,00, seu salário menos desconto deve ser de R$
	 * 2800,00 (3500 * 90%):
	 */
	@Test
	final void calculaSalarioDescontoProgramadorMaiorTresMillTest() {

		Funcionario funcionario = new Funcionario("Flávio", 3500.0, new Cargo().getDESENVOLVEDOR());
		double salarioCalculado = SalarioService.calculaSalarioDesconto(funcionario);
		assertEquals(funcionario.getSalario() * 0.8, salarioCalculado);

	}

	/*
	 * DBAs e testadores possuem desconto de 25% se seus salários forem maiores do
	 * que R$ 2500,0. 15%, em caso contrário.
	 */
	@Test
	final void calculaSalarioDescontoDbaEtestadoresMaiorDoisMillQuinhentosTest() {

		Funcionario funcionario = new Funcionario("Flávio", 3500.0, new Cargo().getDBA());
		double salarioCalculado = SalarioService.calculaSalarioDesconto(funcionario);
		assertEquals(funcionario.getSalario() * 0.75, salarioCalculado);

	}
	
	/*
	 * DBAs e testadores possuem desconto de 25% se seus salários forem maiores do
	 * que R$ 2500,0. 15%, em caso contrário.
	 */
	@Test
	final void calculaSalarioDescontoDbaEtestadoresMenorDoisMillQuinhentosTest() {

		Funcionario funcionario = new Funcionario("Flávio", 1500.0, new Cargo().getTESTADOR());
		double salarioCalculado = SalarioService.calculaSalarioDesconto(funcionario);
		assertEquals(funcionario.getSalario() * 0.85, salarioCalculado);

	}
}
