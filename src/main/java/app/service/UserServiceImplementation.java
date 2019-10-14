package app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import app.dao.BaseDao;
import app.dao.UserDAO;
import app.domain.User;
import app.exception.UserBlockedException;
import app.rm.UserRowMapper;

@Service
public class UserServiceImplementation extends BaseDao implements UserService{
	@Autowired
	private UserDAO userDAO;

	@Override
	public void register(User u) {
		userDAO.save(u);
		
	}
	
	/**
	 * handles login operation
	 */

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName FROM user WHERE loginName=:ln AND password=:pw";
		Map map = new HashMap();
		map.put("ln", loginName);
		map.put("pw", password);
		try {
			User u = getNamedParameterJdbcTemplate().queryForObject(sql, map, new UserRowMapper());
			if (u.getLoginStatus() == UserService.LOGIN_STATUS_BLOCKED) {
				throw new UserBlockedException("Your Account has been blocked! Please contact your system  administrator");
			} else {
				return u;
			}
			
		}
		catch (EmptyResultDataAccessException ex) {
			return null;
			
		}
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLoginStatus(Integer userId, int loginStatus) {
		// TODO Auto-generated method stub
		
	}

}
