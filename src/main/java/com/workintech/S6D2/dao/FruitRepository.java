package com.workintech.S6D2.dao;

import com.workintech.S6D2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    @Query("SELECT s FROM Fruit s ORDER BY s.price ")
    List<Fruit> getAsAsc();

    @Query("SELECT s FROM Fruit s ORDER BY s.price desc")
    List<Fruit> getAsDesc();
    @Query("SELECT s FROM Fruit s WHERE s.name ilike %:name%")
    List<Fruit> searchByName(String name);
}
