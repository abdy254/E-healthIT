package app.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.config.SpringRootConfig;
import app.dao.UserDAO;
import app.domain.User;

public class TestUserDAOUpdate {

	public static void main(String[] args) {
		System.out.println("abdiiiiiii");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = new User();
		u.setUserId(10);
		u.setName("Jane Juma Jacob");
		u.setPhone("07765253782");
		u.setEmail("mohammed@gmail.com");
		u.setAddress("Eldoret");
		u.setLoginName("amit");
		u.setPassword("amit123");
		u.setRole(1);
		u.setLoginStatus(3);
		
		userDAO.update(u);
		System.out.println("----------DATA updated SUCCESSFULLY---------");
	}

}
