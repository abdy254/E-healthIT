/**
 * 
 */
package app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import app.domain.Contact;
import app.service.ContactService;

/**
 * @author abdi
 *
 */
@Controller
public class ContactController {
	
	private ContactService contactService;
	
	@RequestMapping(value = "/user/contact_form")
	public String contactForm(Model m) {
		Contact contact = new Contact();
		m.addAttribute("command", contact);
		return "contact_form";
	}
	
	@RequestMapping(value = "/user/save_contact")
	public String saveContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
		//		Integer userId = (Integer) session.getAttribute("userId");
		//		c.setUserId(userId); //Foreign key : logged in userId
		contactService.save(c);
		return "contact_form";
	}
}
