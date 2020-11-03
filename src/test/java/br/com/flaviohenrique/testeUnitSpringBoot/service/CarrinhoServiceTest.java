package br.com.flaviohenrique.testeUnitSpringBoot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.flaviohenrique.testeUnitSpringBoot.domian.Carrinho;
import br.com.flaviohenrique.testeUnitSpringBoot.domian.Item;

@SpringBootTest
class CarrinhoServiceTest {
	ArrayList<Item> items = new ArrayList<>();
	
	@Test
	final void itemMaiorValor() {
		
		items.add(new Item("mouse",35.99,5));
		items.add(new Item("caneta", 6.99, 3));
		items.add(new Item("Notebook", 7000.52,1));
		items.add(new Item("celular",4000.00,1));		
		Carrinho carrinho = new Carrinho(items);		
		assertEquals(items.get(2).getValorUnitario() * items.get(3).getQuantidade()
				,carrinho.obterItemMaiorValor());
		
	}
	
	@Test
	final void semItem() {
		
		items = new ArrayList<>();		
		Carrinho carrinho = new Carrinho(items);		
		assertEquals(0d,carrinho.obterItemMaiorValor());
		
	}
	
	@Test
	final void unicoItem() {
		
		items.add(new Item("mouse",35.99,5));		
		Carrinho carrinho = new Carrinho(items);		
		assertEquals(items.get(0).getValorUnitario() * items.get(0).getQuantidade()
				,carrinho.obterItemMaiorValor());
		
	}

}
