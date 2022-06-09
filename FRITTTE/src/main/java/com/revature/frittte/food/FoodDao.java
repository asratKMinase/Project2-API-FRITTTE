package com.revature.frittte.food;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDao extends CrudRepository<Food,Integer> {

}
