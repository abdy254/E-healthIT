package app.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.config.SpringRootConfig;
import app.dao.UserDAO;
import app.domain.User;

public class TestUserDAOFindByProp {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		
		List<User> users = userDAO.findByProperty("loginstatus", 1);
		 for (User u: users) {
			 System.out.println(u.getName()+" " + u.getUserId()+" "+ u.getPhone() + " "+ u.getEmail());
		 }
		
	}

}
