package pl.camp.it.distance.coaching.manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.distance.coaching.manager.exceptions.NotEnoughTrainingPlanException;
import pl.camp.it.distance.coaching.manager.services.ICartService;

@Controller
public class CartController {
    @Autowired
    ICartService cartService;

    @RequestMapping(value = "/cart/add/{trainingPlanId}", method = RequestMethod.GET)
    public String addToCart(@PathVariable int trainingPlanId){
        try{
            this.cartService.addToCart(trainingPlanId);
        }catch(NotEnoughTrainingPlanException e) {
        }
      return "shop";
    }
}
