package com.revature.frittte.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "food")
public class Food {
    @Id
    private int id;
    @Column(name = "item_name", length = 50, nullable = false)
    private String item_name;
    @Column(name = "cost_t")
    private int cost;
    private int weight;

    private boolean volume;

    private boolean frozen;
}



