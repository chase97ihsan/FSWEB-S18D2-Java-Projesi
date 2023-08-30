package com.workintech.S6D2.services;

import com.workintech.S6D2.dao.VegetableRepository;
import com.workintech.S6D2.entity.Fruit;
import com.workintech.S6D2.entity.Vegetables;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {

    private VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetables> getAsAsc() {
        return vegetableRepository.getAsAsc();
    }

    @Override
    public List<Vegetables> getAsDesc() {
        return vegetableRepository.getAsDesc();
    }

    @Override
    public Vegetables findById(int id) {
        Optional<Vegetables> vegetableOptional = vegetableRepository.findById(id);
        if (vegetableOptional.isPresent()) {
            return vegetableOptional.get();
        }
        return null;
    }

    @Override
    public Vegetables save(Vegetables vegetables) {
        return vegetableRepository.save(vegetables);
    }

    @Override
    public void delete(Vegetables vegetables) {
        vegetableRepository.delete(vegetables);
    }

    @Override
    public List<Vegetables> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
}
