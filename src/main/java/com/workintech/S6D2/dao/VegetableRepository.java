package com.workintech.S6D2.dao;

import com.workintech.S6D2.entity.Fruit;
import com.workintech.S6D2.entity.Vegetables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetables,Integer> {

    @Query("SELECT s FROM Vegetables s ORDER BY s.price ")
    List<Vegetables> getAsAsc();

    @Query("SELECT s FROM Vegetables s ORDER BY s.price desc")
    List<Vegetables> getAsDesc();
    @Query("SELECT s FROM Vegetables s WHERE s.name ilike %:name%")
    List<Vegetables> searchByName(String name);
}
