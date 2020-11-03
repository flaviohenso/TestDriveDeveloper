package br.com.flaviohenrique.testeUnitSpringBoot.domian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.flaviohenrique.testeUnitSpringBoot.builder.CarrinhoBuilder;

@SpringBootTest
class CarrinhoTest {


	private Carrinho carrinho;
		
	@AfterEach
	public void limpar() {
		carrinho = null;
	}
	
	@Test
	final void itemMaiorValor() {		
		carrinho = new CarrinhoBuilder().contentItems(35.99,7000.52,4000.00).criar();
		assertEquals(7000.52 * 1
				,carrinho.obterItemMaiorValor());		
	}
	
	@Test
	final void semItem() {		
		carrinho = new CarrinhoBuilder().contentItems().criar();
		assertEquals(0d,carrinho.obterItemMaiorValor());		
	}
	
	@Test
	final void unicoItem() {
		carrinho = new CarrinhoBuilder().contentItems(35.99).criar();
		assertEquals(35.99 * 1
				,carrinho.obterItemMaiorValor());		
	}

}
