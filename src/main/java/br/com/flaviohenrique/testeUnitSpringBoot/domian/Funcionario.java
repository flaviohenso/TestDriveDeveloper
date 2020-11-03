package br.com.flaviohenrique.testeUnitSpringBoot.domian;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Funcionario {
	
	private String nome;
	private Double salario;
	private Cargo cargo;
 
}
