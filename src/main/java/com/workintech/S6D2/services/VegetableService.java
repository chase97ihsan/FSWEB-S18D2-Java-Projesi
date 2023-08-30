package com.workintech.S6D2.services;

import com.workintech.S6D2.entity.Fruit;
import com.workintech.S6D2.entity.Vegetables;

import java.util.List;

public interface VegetableService {

    List<Vegetables> getAsAsc();

    List<Vegetables> getAsDesc();

    Vegetables findById(int id);

    Vegetables save(Vegetables vegetables);

    void delete(Vegetables vegetables);
    List<Vegetables> searchByName(String name);

}
