package ci.digitalacademy.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")

public class RapportController {

    @GetMapping("/rapport")
    public String showRapport(){

        return "report/rapport";
    }
}
