package br.com.flaviohenrique.testeUnitSpringBoot.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import br.com.flaviohenrique.testeUnitSpringBoot.domian.User;
import br.com.flaviohenrique.testeUnitSpringBoot.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRepository userRepository;

	@Test
	final void findAllUsers() throws Exception {
		User user = new User("teste", 25, "DOC12355");
		List<User> userList = List.of(user);
		
		when(userRepository.findAll()).thenReturn(userList);
		this.mockMvc.perform(get("/users"))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("DOC12355")));
	}

}
