package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.UserService;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/add")
    public String showAddUserPage(Model model){
        log.debug("Request show to add user forms");
        model.addAttribute("user", new User());
        return "users/form";
    }

    @PostMapping
    public String saveUser(UserDTO user){
        log.debug("Request to save user:{}", user);
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping
    public String showUserPages(Model model){

        //pour afficher la journalisation, ne jamais mettre les informations sensibles dans le debug
        log.debug("Request to show user list ");

        final List<UserDTO> users = userService.findAll();
        model.addAttribute("users", users);
        return "users/add";
    }

    @GetMapping("/{id}")
    public String updateUser(Model model, @PathVariable Long id){
        log.debug("Request to update user");
        Optional<UserDTO>  user = userService.findOne(id);
        if (user.isPresent()){
            model.addAttribute("user", user.get());
            return "users/form";
        }
        else {
            return "redirect:/users";
        }

    }


    @PostMapping("/{id}")
    public String showDeleteUsers( @PathVariable Long id){
        log.debug("Request delete users");
        userService.delete(id);
        return "redirect:/users";
    }







}
