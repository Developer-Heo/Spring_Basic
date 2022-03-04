package Spring.Spring_Basic.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // localhost8080 호출시 불러옴
    public String home() {
        return "home";
    }
}
