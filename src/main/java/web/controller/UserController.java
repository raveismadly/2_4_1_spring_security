package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

	@GetMapping(value = "hello")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC-SECURITY application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "hello";
	}

    @GetMapping(value = "login")
    public ModelAndView  loginPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
    	return model;
    }
    @GetMapping(value = "user")
	public String userPage(){
		return "hello";
	}
	// Все CRUD-операции и страницы для них должны быть доступны только пользователю с ролью admin по url: /admin/.
	//5. Пользователь с ролью user должен иметь доступ только к своей домашней странице /user, где выводятся его данные.
	// Доступ к этой странице должен быть только у пользователей с ролью user – не забывайте про несколько ролей у пользователя!
}