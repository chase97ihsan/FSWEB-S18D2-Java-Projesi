package com.workintech.S6D2.controller;

import com.workintech.S6D2.entity.Fruit;
import com.workintech.S6D2.entity.Vegetables;
import com.workintech.S6D2.exceptions.FruitException;
import com.workintech.S6D2.services.FruitService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
@Validated
public class FruitsController {

    private FruitService fruitService;

    public FruitsController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<Fruit> getAsAsc() {
        return fruitService.getAsAsc();
    }

    @GetMapping("/{id}")
    public Fruit getById(@Positive @PathVariable int id) {
        Fruit fruit = fruitService.findById(id);
        if (fruit == null) {
            throw new FruitException("This id is not exist", HttpStatus.NOT_FOUND);
        }
        return fruit;
    }

    @GetMapping("/desc")
    public List<Fruit> getAsDesc() {
        return fruitService.getAsDesc();
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @PostMapping("/")
    public Fruit postOrPut(@Validated @RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@Positive @PathVariable int id) {
        Fruit fruit = getById(id);
        fruitService.delete(fruit);
        return fruit;
    }
}
