package br.com.flaviohenrique.testeUnitSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.flaviohenrique.testeUnitSpringBoot.domian.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findUserByNameAndDocument(String name, String doc);
	
	public User findUserByName(String name);
	
}
