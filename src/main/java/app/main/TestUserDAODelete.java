package app.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.config.SpringRootConfig;
import app.dao.UserDAO;

public class TestUserDAODelete {

	public static void main(String[] args) {
		ApplicationContext ctx =new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO =ctx.getBean(UserDAO.class);
		userDAO.delete(1);
		

	}

}
