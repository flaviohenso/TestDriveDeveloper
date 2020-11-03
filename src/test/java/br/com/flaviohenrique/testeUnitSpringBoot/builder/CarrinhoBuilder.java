package br.com.flaviohenrique.testeUnitSpringBoot.builder;


import br.com.flaviohenrique.testeUnitSpringBoot.domian.Carrinho;
import br.com.flaviohenrique.testeUnitSpringBoot.domian.Item;

public class CarrinhoBuilder {
	
	private Carrinho carrinho = new Carrinho();
	
	public CarrinhoBuilder contentItems(Double... valores) {

		for (int i = 0; i < valores.length; i++) {
			carrinho.adicionar(new Item("item",valores[i],1));
		}
	
		
		return this;
	}

	public Carrinho criar() {
		return carrinho;
	}
	
	
}
