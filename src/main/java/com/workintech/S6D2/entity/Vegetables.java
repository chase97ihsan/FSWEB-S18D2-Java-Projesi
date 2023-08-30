package com.workintech.S6D2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vegetables", schema = "spring")
public class Vegetables {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotBlank
    @Size(min=2,max=10,message="Name must be between 2 and 10 characters.")
    private String name;
    @Column(name = "price")
    @DecimalMin("5")
    private double price;
    @Column(name = "is_grown_on_tree")
    private boolean isGrownOnTree;

}