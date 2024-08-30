package ci.digitalacademy.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")

public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboardPage(){
        return "home/dashboard";
    }

}
