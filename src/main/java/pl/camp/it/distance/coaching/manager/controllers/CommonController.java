package pl.camp.it.distance.coaching.manager.controllers;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.distance.coaching.manager.session.SessionObject;

@Controller
public class CommonController {
    @Resource
    SessionObject sessionObject;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String manin(Model model) {
        model.addAttribute("sessionObject" , this.sessionObject);
        return "main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "redirect:/";
    }
}
