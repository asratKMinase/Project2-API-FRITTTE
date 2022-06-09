package com.revature.frittte.food;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Food {
    @Id

    private int id;
    private String item_name;
    private int cost;
    private int weight;
    private boolean liquid;
    private boolean frozen;

    public int getId() {
        return id;

    }

    public Food(int id, String item_name, int cost, int weight, boolean liquid, boolean frozen) {
        this.id = id;
        this.item_name = item_name;
        this.cost = cost;
        this.weight = weight;
        this.liquid = liquid;
        this.frozen = frozen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isLiquid() {
        return liquid;
    }

    public void setLiquid(boolean liquid) {
        this.liquid = liquid;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", item_name='" + item_name + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                ", liquid=" + liquid +
                ", frozen=" + frozen +
                '}';
    }
}



