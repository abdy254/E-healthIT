/**
 * 
 */
package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.BaseDao;
import app.dao.ContactDAO;
import app.domain.Contact;
import app.rm.ContactRowMapper;
import app.util.StringUtility;

/**
 * @author abdi
 *
 */
@Service
public class ConatctServiceImplementation extends BaseDao implements ContactService {
	
	@Autowired
	private ContactDAO contactDAO;
	
	public void save(Contact c) {
		contactDAO.save(c);
	}
	
	public void update(Contact c) {
		contactDAO.update(c);
		
	}
	
	public void delete(Integer contactId) {
		contactDAO.delete(contactId);
	}
	
	public void delete(Integer[] contactId) {
		String ids = StringUtility.toCommaSeparatedString(contactId);
		String sql = "DELETE FROM contact WHERE contactId IN(" + ids + ")";
		getJdbcTemplate().update(sql);
		
	}
	
	public List<Contact> findUserContact(Integer userId, String text) {
		String sql = "SELECT * FROM contact WHERE userId=? AND (name LIKE '%" + text + "%' OR phone LOKE '%" + text
		        + "%' OR email LIKE '%" + text + "%' OR address LIKE '%" + text + "%')";
		return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
	}
	
	public List<Contact> findUserContact(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
