package app.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import app.domain.Contact;
import app.domain.User;

@Repository
public class ContactDAOImplementation extends BaseDao implements ContactDAO{

	public void save(Contact c) {
		String sql = "INSERT INTO contact(userId, name, phone, email, address, remarks) VALUES(:userId, :name, :phone, :email, :address, :remarks)";
		Map m = new HashMap();
		m.put("userId",c.getUserId());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remarks", c.getRemark());
		
		SqlParameterSource ps = new MapSqlParameterSource(m);
		KeyHolder kh = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		c.setContactId(kh.getKey().intValue());
		
	}

	public void update(Contact c) {
		String sql = "UPDATE contact(userId, name, phone, email, address, remarks) VALUES(:userId, :name, :phone, :email, :address, :remarks)";

	}

	public void delete(Contact c) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Integer userId) {
		// TODO Auto-generated method stub
		
	}

	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
