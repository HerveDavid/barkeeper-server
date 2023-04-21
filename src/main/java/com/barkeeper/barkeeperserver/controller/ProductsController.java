package com.barkeeper.barkeeperserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ProductsController {

    @GetMapping("/hello")
    public Flux<String> handle() {
        return Flux.just("Hello World");
    }


}
