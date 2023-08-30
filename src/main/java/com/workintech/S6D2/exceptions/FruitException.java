package com.workintech.S6D2.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class FruitException extends RuntimeException {

    private HttpStatus httpStatus;

    public FruitException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
