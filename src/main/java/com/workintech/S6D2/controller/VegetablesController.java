package com.workintech.S6D2.controller;

import com.workintech.S6D2.entity.Fruit;
import com.workintech.S6D2.entity.Vegetables;
import com.workintech.S6D2.services.VegetableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
public class VegetablesController {
    private VegetableService vegetableService;

    public VegetablesController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public List<Vegetables> getAsAsc() {
        return vegetableService.getAsAsc();
    }

    @GetMapping("/{id}")
    public Vegetables getById(@PathVariable int id) {
        return vegetableService.findById(id);
    }

    @GetMapping("/desc")
    public List<Vegetables> getAsDesc() {
        return vegetableService.getAsDesc();
    }

    @GetMapping("/name/{name}")
    public List<Vegetables> getByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }

    @PostMapping("/")
    public Vegetables postOrPut(@RequestBody Vegetables vegetables) {
        return vegetableService.save(vegetables);
    }

    @DeleteMapping("/{id}")
    public Vegetables delete(@PathVariable int id) {
        Vegetables vegetables = getById(id);
        if (vegetables == null) {
            //TODO throw not found Exception
        }
        vegetableService.delete(vegetables);
        return vegetables;
    }
}
