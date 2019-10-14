package app.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.config.SpringRootConfig;
import app.domain.User;
import app.service.UserService;

public class TestUserServiceRegister {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		
		User user = new User();
		user.setName("Dancan");
		user.setPhone("091034657");
		user.setEmail("dndiith@healthit.uonbi.ac.ke");
		user.setAddress("Kikuyu");
		user.setLoginName("dancantowers");
		user.setLoginStatus(1);
		user.setRole(UserService.ROLE_ADMIN);
		userService.register(user);
		
		System.out.println("<------data saved succesfully-------->");

	}

}
