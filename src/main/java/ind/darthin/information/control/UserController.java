package ind.darthin.information.control;

import ind.darthin.information.pojo.User;
import ind.darthin.information.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	private IUserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(final IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String findUsers(Model model) throws Exception {
		model.addAttribute("user", new User());
		model.addAttribute("findUsers", this.userService.findUsers());
		return "user";
	}

	//For add and update user both
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") final User user) throws Exception {
		if (user.getId() == null) {
			//new user, add it
			user.setPassword("a");
			this.userService.addUser(user);
		} else {
			//existing user, call update
			this.userService.updateUser(user);
		}

		return "redirect:/users";
	}

	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") final long id) throws Exception {
		this.userService.removeUser(id);
		return "redirect:/users";
	}

	@RequestMapping("/edit/{id}")
	public String editUser(@PathVariable("id") final int id, final Model model) throws Exception {
		model.addAttribute("user", this.userService.getUserById(id));
		model.addAttribute("findUsers", this.userService.findUsers());
		return "user";
	}

}
