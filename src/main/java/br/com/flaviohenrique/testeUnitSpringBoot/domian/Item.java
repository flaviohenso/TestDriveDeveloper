package br.com.flaviohenrique.testeUnitSpringBoot.domian;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {

	private String descricao;
	private Double valorUnitario;
	private Integer quantidade;
	
	
}
