package com.barkeeper.barkeeperserver.controller;

import com.barkeeper.barkeeperserver.entities.Product;
import com.barkeeper.barkeeperserver.repository.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/{productId}")
    public Optional<ResponseEntity<Product>> getProduct(@PathVariable UUID productId) {
        return productsRepository.findById(productId).map(product -> new ResponseEntity<>(product, HttpStatus.OK));
    }

}
