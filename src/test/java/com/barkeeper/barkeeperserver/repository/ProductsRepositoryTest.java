package com.barkeeper.barkeeperserver.repository;

import com.barkeeper.barkeeperserver.entities.Product;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductsRepositoryTest {

    @Autowired
    private ProductsRepository productsRepository;

    @Before
    public void setUp() throws Exception {
        Product product1 = new Product("farine");
        Product product2 = new Product("cereale");

        assertNull(product1.getId());
        assertNull(product2.getId());

        productsRepository.save(product1);
        productsRepository.save(product2);

        assertNotNull(product1.getId());
        assertNotNull(product2.getId());

    }

    @Test
    public void testFetchData() {
//        Product farine = productsRepository.findByName("farine");
//
//        assertNotNull(farine);

//        StepVerifier.create(productsRepository.findAll())
//                        .expectNextCount(2)
//                        .expectComplete()
//                        .verify();
    }


}