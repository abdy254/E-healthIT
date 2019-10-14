package app.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.config.SpringRootConfig;
import app.dao.UserDAO;
import app.domain.User;

public class TestUserDAOFindAll {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		
		List<User> users = userDAO.findAll();
		
		  for (User u : users) { 
			  System.out.println(u.getUserId()+ " "+u.getRole()); 
			  }
		 
	}

}
