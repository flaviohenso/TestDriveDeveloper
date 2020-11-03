package br.com.flaviohenrique.testeUnitSpringBoot.service;

import org.springframework.stereotype.Service;

import br.com.flaviohenrique.testeUnitSpringBoot.domian.Carrinho;
import br.com.flaviohenrique.testeUnitSpringBoot.domian.Item;

@Service
public class CarrinhoService {

	public Double obterItemMaiorValor(Carrinho carrinho) {

		Item maior = null;
		if (!carrinho.getItems().isEmpty()) {
			maior = carrinho.getItems().get(0);
			for (Item iterable_element : carrinho.getItems()) {				
				if (maior.getValorUnitario() * maior.getQuantidade() < iterable_element.getValorUnitario()
						* iterable_element.getQuantidade()) {
					maior = iterable_element;
				}
			}

			return maior.getValorUnitario() * maior.getQuantidade();
		}
		return 0d;
	}
}
