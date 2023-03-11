package pl.camp.it.distance.coaching.manager.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.distance.coaching.manager.model.TrainingPlan;
import pl.camp.it.distance.coaching.manager.services.ITrainingPlanService;
import pl.camp.it.distance.coaching.manager.session.SessionObject;

@Controller
public class ShopController {
    @Resource
    SessionObject sessionObject;
    @Autowired
    ITrainingPlanService trainingPlanService;

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String shop(Model model){
        model.addAttribute("sessionObject" , this.sessionObject);
        model.addAttribute("trainingsPlan", this.trainingPlanService.getTrainingPlanList());
        for(TrainingPlan element : trainingPlanService.getTrainingPlanList()){
        }return "shop";
    }

}
