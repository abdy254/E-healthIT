package app.main;

import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import app.config.SpringRootConfig;

public class Test {

	public static void main(String[] args){
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			DataSource ds = ctx.getBean(DataSource.class);
			JdbcTemplate jt = new JdbcTemplate(ds);
			String sql = "INSERT INTO user(name, phone) values(?,?)";
			Object[] param = new Object[] {"abdi","0712014130"};
			jt.update(sql, param);
			System.out.println("--------SQL EXECUTED!!----------------");
			
	}

}
