package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class AdminController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "adminPage";
    }

    @GetMapping(value = "/admin/users")
    public String printAllUsers(ModelMap model) {
        List<User> list = service.allUsers();
        model.addAttribute("allUsers", list);
        return "allUsers";
    }

    @GetMapping(value = "/admin/add")
    public String addUserPage(Model model) {
        model.addAttribute("addUser");
        return "addUser";
    }

    @PostMapping(value = "/admin/add")
    public String addUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping(value = "/admin/edit/{id}")
    public String editUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "editUser";
    }

    @PostMapping(value = "/admin/edit")
    public String editFilm(@ModelAttribute("user") User user) {
        service.updateUser(user);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.GET)
    public String deleteUserPage(@PathVariable("id") int id) {
        User user = service.getUserById(id);
        service.deleteUser(user);
        return "redirect:/admin/users";
    }
}
