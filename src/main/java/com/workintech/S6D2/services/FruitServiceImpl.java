package com.workintech.S6D2.services;

import com.workintech.S6D2.dao.FruitRepository;
import com.workintech.S6D2.entity.Fruit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> getAsAsc() {
        return fruitRepository.getAsAsc();
    }

    @Override
    public List<Fruit> getAsDesc() {
        return fruitRepository.getAsDesc();
    }

    @Override
    public Fruit findById(int id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if (fruitOptional.isPresent()) {
            return fruitOptional.get();
        }
        return null;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public void delete(Fruit fruit) {
        fruitRepository.delete(fruit);
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}
