package br.com.flaviohenrique.testeUnitSpringBoot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.flaviohenrique.testeUnitSpringBoot.domian.User;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Sql(scripts = "/sql/insertUser_para_test.sql")
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@BeforeEach
	final void preTest() {
		System.out.println("Antes do teste");
	}
	
	@Test
	final void insertUser() {
		User user = new User("name",11,"DOC12355");
		Integer countUser = userRepository.findAll().size();
		assertEquals( 0 , countUser);
	}
	
	@Test
	final void checkUserSavedWithDocument() {
		User user = new User("name", 11, "DOC12355");
		userRepository.save(user);
		Integer countUser = userRepository.findAll().size();
		assertEquals(1, countUser);
		User user1 = userRepository.findUserByNameAndDocument("name", "DOC12355");
		
		assertNotNull(user1);
		assertEquals(user, user1);
		
	}
	
	@Test
	final void checkUserSavedWithDocumentPassingOtherDocumentShouldReturnNull() {
		User user = new User("name", 11, "DOC12355");
		userRepository.save(user);
		Integer counUser = userRepository.findAll().size();
		assertEquals(1, counUser);
		User user1 = userRepository.findUserByNameAndDocument("name", "DOD12355");
		
		assertNull(user1);
	}
	
	@AfterEach
	public void outTest() {
		System.out.println("Após terminar os teste");
		System.out.println(userRepository.findAll());
	}
}
