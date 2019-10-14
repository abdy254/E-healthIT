package app.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.config.SpringRootConfig;
import app.dao.UserDAO;
import app.domain.User;

public class TestUserDao {

	public static void main(String[] args) {
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx2.getBean(UserDAO.class);
		User u = new User();
		u.setName("Jane");
		u.setPhone("0776354828");
		u.setEmail("djsadick.com");
		u.setAddress("Meru");
		u.setLoginName("Magatha");
		u.setPassword("987827");
		u.setRole(1);
		u.setLoginStatus(1);
		userDAO.save(u);
		System.out.println("----------DATA SAVED SUCCESSFULLY---------");

	}

}
