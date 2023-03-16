package pl.camp.it.distance.coaching.manager.services.impl;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.distance.coaching.manager.database.ITrainingPlanDAO;
import pl.camp.it.distance.coaching.manager.exceptions.NotEnoughTrainingPlanException;
import pl.camp.it.distance.coaching.manager.model.OrderPosition;
import pl.camp.it.distance.coaching.manager.model.TrainingPlan;
import pl.camp.it.distance.coaching.manager.services.ICartService;
import pl.camp.it.distance.coaching.manager.session.SessionObject;

import java.util.Map;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {
    @Resource
    SessionObject sessionObject;
    @Autowired
    ITrainingPlanDAO trainingPlanDAO;


    @Override
    public void addToCart(int trainingPlanId) {
        Map<Integer, OrderPosition> cart = this.sessionObject.getCart();
        Optional<TrainingPlan> trainingBox = this.trainingPlanDAO.getTrainingPlanById(trainingPlanId);
        if(trainingBox.isEmpty()){
            return;
        }
        if(cart.get(trainingPlanId) == null && trainingBox.get().getQuantity()>0) {
            cart.put(trainingPlanId , new OrderPosition(trainingBox.get(), 1));
        }else if(trainingBox.get().getQuantity() > cart.get(trainingPlanId).getAmount()){
            cart.get(trainingPlanId).increamentAmount();
        }else{
            throw new NotEnoughTrainingPlanException();
        }
    }
}
