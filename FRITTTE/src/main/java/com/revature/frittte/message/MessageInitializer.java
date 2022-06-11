package com.revature.frittte.message;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageInitializer {

    private String id;
    private String chatUsername;
    private String title;
    private String date;

}
