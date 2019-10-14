package app.dao;

import app.domain.Contact;
import app.domain.User;

public interface ContactDAO {
	public void save(Contact c);
	public void update(Contact c);
	public void delete(Contact c);
	public void delete(Integer userId);
	public User findById(Integer userId);

}
