package home.danil.myboot.PP312.controllers;


import home.danil.myboot.PP312.models.User;
import home.danil.myboot.PP312.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Neil Alishev
 */
@Controller
@RequestMapping("templates/users")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", usersService.findAll());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", usersService.findOne(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user) {

        usersService.save(user);
        return "redirect:/templates/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", usersService.findOne(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, @PathVariable("id") long id) {

        usersService.update(id, user);
        return "redirect:/templates/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        usersService.delete(id);
        return "redirect:/templates/users";
    }
}