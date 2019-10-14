/**
 * 
 */
package app.service;

import java.util.List;

import app.domain.Contact;

/**
 * specifies all business operation for contact entity
 * 
 * @author abdi
 */
public interface ContactService {
	
	public void save(Contact c);
	
	public void update(Contact c);
	
	public void delete(Integer contactId);
	
	public void delete(Integer[] contactId);//delete multiple contacts
	
	public List<Contact> findUserContact(Integer userId, String text);
	
	public List<Contact> findUserContact(Integer userId);//	this method returns all User Contact (logged in user)
	
}
