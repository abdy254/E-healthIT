package app.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.config.SpringRootConfig;
import app.dao.UserDAO;
import app.domain.User;

public class TestUserDAOFindUserRecord {

	public static void main(String[] args) {

		  ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class); 
		  UserDAO userDAO = ctx.getBean(UserDAO.class); 
		  User u =userDAO.findById(10);
		  System.out.println("--------User detail ---------");
		  System.out.println(u.getUserId());
		  System.out.println(u.getPhone());
		  System.out.println(u.getAddress());
		  System.out.println(u.getEmail());
		  System.out.println(u.getLoginName());
		  System.out.println(u.getLoginStatus());
		  System.out.println(u.getRole());
		
	}
}
