package com.knoldus.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
public class RandomLongController {
    private static Random random = new Random();

    @GetMapping("/random/long")
    Long randomLong() {
        return random.nextLong();
    }
}
