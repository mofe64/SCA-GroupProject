package com.groupOne.taskOne;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberProfilerTest {
    NumberProfiler numberProfiler;
    @BeforeEach
    void setUp() {
        numberProfiler = new NumberProfiler();
    }

    @AfterEach
    void tearDown() {
        numberProfiler = null;
    }

    @Test
    void testThatChecksForOddNumber(){
        numberProfiler.setNumber(13);
        assertTrue(numberProfiler.isOdd());
    }
    @Test
    void testThatChecksForEvenNumber(){
        numberProfiler.setNumber(16);
        assertTrue(numberProfiler.isEven());
    }

    @Test
    void testThatChecksForPrimeNumber(){
        numberProfiler.setNumber(3);
        assertTrue(numberProfiler.isPrimeNumber());
    }

    @Test
    void testThatChecksForPerfectSquare(){
        numberProfiler.setNumber(625);
        assertTrue(numberProfiler.isPerfectSquare());
    }

    @Test
    void testThatGetsAndDisplaysFirstTenMultiplesOfANumber(){
         numberProfiler.setNumber(2);
         int[] numMultiples = {2,4,6,8,10,12,14,16,18,20};
         assertArrayEquals(numMultiples, numberProfiler.getMultiples());
    }

    @Test
    void testThatGetsAndDisplaysFactorsOfANumber(){
        numberProfiler.setNumber(6);
        int[] numFactors = {1,2,3,6};
        assertEquals(numFactors.length, numberProfiler.getFactors().size());
    }
    @Test
    void test(){
        numberProfiler.setNumber(100);
        System.out.println(numberProfiler.generateNumberProfile());
    }
}