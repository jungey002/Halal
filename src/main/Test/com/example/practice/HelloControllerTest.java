package com.example.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {
    @Test
    void testmycode(){
        assertEquals(HelloController.multiply(12),144);
    }

}