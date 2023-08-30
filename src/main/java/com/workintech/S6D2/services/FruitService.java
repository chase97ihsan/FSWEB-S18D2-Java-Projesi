package com.workintech.S6D2.services;

import com.workintech.S6D2.entity.Fruit;

import java.util.List;

public interface FruitService {

    List<Fruit> getAsAsc();
    List<Fruit> getAsDesc();
    Fruit findById(int id);
    Fruit save(Fruit fruit);
    void delete(Fruit fruit);
    List<Fruit> searchByName(String name);


}
