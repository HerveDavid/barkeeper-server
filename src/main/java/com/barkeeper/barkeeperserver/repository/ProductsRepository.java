package com.barkeeper.barkeeperserver.repository;

import com.barkeeper.barkeeperserver.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<Product, UUID> {

}
