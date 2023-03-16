package pl.camp.it.distance.coaching.manager.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.camp.it.distance.coaching.manager.exceptions.UserValidationException;
import pl.camp.it.distance.coaching.manager.model.User;
import pl.camp.it.distance.coaching.manager.services.IAuthenticationService;
import pl.camp.it.distance.coaching.manager.session.SessionObject;
import pl.camp.it.distance.coaching.manager.valitators.UserValidator;

@Controller
public class AuthenticationController {
    @Resource
    SessionObject sessionObject;
    @Autowired
    IAuthenticationService authenticationService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
    model.addAttribute("sessionObject" , this.sessionObject);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String login, String password) {
        try{
            UserValidator.validateLogin(login);
            UserValidator.validatePassword(password);
        }catch (UserValidationException e){
            e.printStackTrace();
        }
        this.authenticationService.authenticate(login,password);
        if(!this.sessionObject.isLogged()){
            return "redirect:/login";
        }
        return "redirect:/shop";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("sessionObject" , this.sessionObject);
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user,
                           @RequestParam String password2) {
          try {
            UserValidator.validateUser(user, password2);
            this.authenticationService.registerUser(user);
        } catch (UserValidationException e) {
            e.printStackTrace();
            return "redirect:/register";
        }
      return "redirect:/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.authenticationService.logout();
    return "redirect:/";}
}
