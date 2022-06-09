package com.revature.frittte.food;

import com.revature.frittte.customer.Customer;
import com.revature.frittte.exception.InvalidRequestException;
import com.revature.frittte.exception.ResourcePersistanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FoodService {
    private FoodDao foodDao;

    @Autowired
    public FoodService(FoodDao foodDao){
        this.foodDao = foodDao;
    }

    public List<Food> findAll(){
        List<Food> foods = (List <Food>) foodDao.findAll();
        return foods;
    }

    public  boolean deleteById(int id){
      foodDao.deleteById(id);
      return true;



    }
    public Food readById(int id){
        Food food = foodDao.findById(id).get();
        return food;

    }




    public boolean validateUsernameNotUsed(int id){
        return foodDao.existsById(id);
    }

    public Food create(Food newFoodItem){
        if(!validateInput(newFoodItem)){ // checking if false
            // TODO: throw - what's this keyword?
            throw new InvalidRequestException("New FoodItem was not validated, either empty String or null values");
        }

        // TODO: Will implement with JDBC (connecting to our database)

        Food persistedFood = foodDao.save(newFoodItem);

        if(persistedFood == null){
            throw new ResourcePersistanceException("newFoodItem was not persisted to the database upon registration");
        }
        return persistedFood;
    }



    public boolean validateInput(Food newFoodItem) {
        if(newFoodItem == null) return false;
        if(newFoodItem.getId()<0) return false;
        if(newFoodItem.getItem_name()== null || newFoodItem.getItem_name().trim().equals("")) return false;
        if(newFoodItem.getCost()<0) return false;
        if(newFoodItem.getWeight()<0) return false;
        if((newFoodItem.isLiquid() != true)|| (newFoodItem.isLiquid() != false )) return false;
        return((newFoodItem.isFrozen() != true)|| (newFoodItem.isFrozen() != false )) ;
        }



}
