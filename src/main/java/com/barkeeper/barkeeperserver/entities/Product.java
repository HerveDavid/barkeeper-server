package com.barkeeper.barkeeperserver.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produits")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nom")
    private String name;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "volume")
    private Double volume;

    @Column(name = "prix")
    private Double price;

    @Column(name = "recette")
    private String recipe;

    @Column(name = "estAuMenu")
    private Boolean isInRecipe;

    @Column(name = "tva")
    private Double vat;

    public Product(String name) {
        this.name = name;
    }
}
