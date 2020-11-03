package br.com.flaviohenrique.testeUnitSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flaviohenrique.testeUnitSpringBoot.domian.User;
import br.com.flaviohenrique.testeUnitSpringBoot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User findUser(String name) {
		return userRepository.findUserByName(name);
	}
	
	public User create(User user) {
		return userRepository.saveAndFlush(user);
	}
	
	
}
