package com.revature.frittte.food;

import com.revature.frittte.customer.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FoodServlet {

    private FoodService foodService;

    public FoodServlet(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/newFoodItem")
    public ResponseEntity<Food> createFoodItem(@RequestBody Food newFood){
        Food food = foodService.create(newFood);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @GetMapping("/findFoodItem")
    public ResponseEntity<Food> findFoodItem(@RequestBody String findFood){
        Food food = foodService.readById(findFood);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @GetMapping("/findAllFoodItems")
    public ResponseEntity<List> findAllFoodItems(){
        return new ResponseEntity<>(foodService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestBody String id) {
        boolean deleteFood = foodService.deleteById(id);
    }

}
