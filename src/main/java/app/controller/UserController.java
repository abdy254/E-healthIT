/**
 * 
 */
package app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.command.LoginCommand;
import app.command.UserCommand;
import app.domain.User;
import app.exception.UserBlockedException;
import app.service.UserService;

/**
 * @author abdi
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = { "/", "/index" })
	public String index(Model m) {
		m.addAttribute("command", new LoginCommand());
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
		try {
			User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
			//login failed
			if (loggedInUser == null) {
				
				m.addAttribute("err", "Login Failed! enter valid credentials");
				return "index";
				
			}
			/*	login succcess
				check the role and redirect to appropriate dashboard
				*/
			else { 
				if (loggedInUser.getRole() == userService.ROLE_ADMIN) {
					//add user detail in session (assign session to logged in user)
					addUserInSession(loggedInUser, session);
					return "redirect:admin/dashboard";
			}else if (loggedInUser.getRole() == userService.ROLE_USER) {
				addUserInSession(loggedInUser, session);
				return "redirect:user/dashboard";
				
			}
			else {
					//add error message and go back to login-form
				m.addAttribute("err", "Invalid User ROLE");
					return "index";//JSP - Login FORM
					
			}
			}
		}
		catch (UserBlockedException ex) {
			m.addAttribute("err", ex.getMessage());
			
			return "index";
		}
	}
	
	@RequestMapping(value = { "/logout" })
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index?act=lo";
	}
	
	@RequestMapping(value = { "/user/dashboard" })
	public String UserDashboard() {
		return "dashboard_user";
	}
	
	@RequestMapping(value = { "/admin/dashboard" })
	public String AdminDashboard() {
		return "dashboard_admin";
	}
	
	@RequestMapping(value = "/reg_form")
	public String registrationForm(Model m) {
		//TODO command
		UserCommand cmd = new UserCommand();
		m.addAttribute("command", cmd);
		return "reg_form";
	}
	
	@RequestMapping(value = "/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
		try {
			User user = cmd.getUser();
			user.setRole(UserService.ROLE_USER);
			user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
			userService.register(user);
			return "redirect:index?act=reg";
		}
		catch (DuplicateKeyException e) {
			e.printStackTrace();
			m.addAttribute("err", "This Username is already taken, Please Use Another Username");
			return "reg_form";
			
		}

	}
	private void addUserInSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
		
	}
	
}

