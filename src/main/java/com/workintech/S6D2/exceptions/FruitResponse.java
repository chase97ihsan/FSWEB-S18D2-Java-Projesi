package com.workintech.S6D2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FruitResponse {

    private int status;
    private String message;
    private long timeStamp;

}
