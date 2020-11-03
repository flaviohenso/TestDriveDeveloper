package br.com.flaviohenrique.testeUnitSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flaviohenrique.testeUnitSpringBoot.domian.User;
import br.com.flaviohenrique.testeUnitSpringBoot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/{name}")
	public ResponseEntity<User> findUser(@PathVariable String name) {
		User user;
		if (!name.isEmpty() && !name.isBlank() && name != null) {
			
			user = userService.findUser(name);
			// status cod 200
			return ResponseEntity.ok(user);
		}
		// Status cod 404
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User user) {
		User userok = null;
		if (user != null) {
			userok = userService.create(user);
		}
		if (userok != null) {
			return ResponseEntity.ok(userok);
		}
		return ResponseEntity.noContent().build();
	}

}
