package br.com.flaviohenrique.testeUnitSpringBoot.domian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.flaviohenrique.testeUnitSpringBoot.service.CarrinhoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrinho {

	private ArrayList<Item> items = new ArrayList<>();
	

	private CarrinhoService carrinhoService;
	
	@Autowired
	public Carrinho(CarrinhoService carrinhoService) {
		this.carrinhoService = carrinhoService;
	}
	
	public Carrinho(ArrayList<Item> items) {
		this.items = items;
	}
	
	public Double obterItemMaiorValor() {

		Item maior = null;
		if (!items.isEmpty()) {
			maior = items.get(0);
			for (Item iterable_element : items) {				
				if (maior.getValorUnitario() * maior.getQuantidade() < iterable_element.getValorUnitario()
						* iterable_element.getQuantidade()) {
					maior = iterable_element;
				}
			}

			return maior.getValorUnitario() * maior.getQuantidade();
		}
		return 0d;
	}


	public void adicionar(Item item) {
		items.add(item);
	}

	

}
