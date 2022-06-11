package com.revature.frittte.food;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDao extends CrudRepository<Food,Integer> {
    @Query(value = "FROM Food WHERE id= :id AND item_name = :item_name")
    Food authenticateFood(int id, String item_name);

}
