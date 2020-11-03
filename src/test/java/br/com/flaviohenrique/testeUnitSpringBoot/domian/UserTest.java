package br.com.flaviohenrique.testeUnitSpringBoot.domian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class UserTest {

	@Test
	final void test() {
		User user = new User("name", 12, "DOC12543");
        assertEquals("name", user.getName());
        assertTrue(user.toString().contains("User ["));
	}

}
