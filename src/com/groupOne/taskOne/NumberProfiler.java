package com.groupOne.taskOne;
/* Write an application that receives a number as an input and returns that number's profile(i.e all facts
 about that number, e.g if the number is odd or even, facts of the number , if the number is a prime number
  or not,  if it is a perfect square etc.)*/

//start

import java.util.ArrayList;

public class NumberProfiler {
    private int number;

    //    public NumberProfiler(int num){
//
//    }
    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isOdd() {
        if (number % 2 != 0) {
            return true;
        }
        return false;
    }

    public boolean isEven() {
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }

    public boolean isPrimeNumber() {
        if (number > 2) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return number == 1 || number == 2;
    }

    public boolean isPerfectSquare() {
        double squareRoot = Math.sqrt(number);
        if (squareRoot * squareRoot == number) {
            return true;
        }
        return false;
    }


    public int[] getMultiples() {
        int[] multiples = new int[10];
        int multiple;
        for (int i = 1; i <= 10; i++) {
            multiple = i * number;
            multiples[i - 1] = multiple;
        }
        return multiples;
    }

    public ArrayList<Integer> getFactors() {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                if (i * j == number) {
                    boolean factorIPresent = factors.contains(i);
                    boolean factorJPresent = factors.contains(j);
                    if (factorIPresent == false) {
                        factors.add(i);
                    }
                    if (factorJPresent == false) {
                        factors.add(j);
                    }
                }

            }

        }
        return factors;
    }

    public String generateNumberProfile() {
        String numberProfile = "The number profile for " + number + " : \n";
        if (isOdd()) {
            numberProfile += "\nis an odd number";
        }
        if (isEven()) {
            numberProfile += "\nis an even number";
        }
        if (isPerfectSquare()) {
            numberProfile += "\nis a perfect square";
        }
        if (isPrimeNumber()) {
            numberProfile += "\nis a prime number";
        }
        numberProfile += "\nThe first 10 multiples of " + number + " are \n";
        for (int multiple : getMultiples()) {
            numberProfile += multiple + " ";
        }
        numberProfile += "\n";

        numberProfile += "The factors of " + number + " are \n";
        for (int factor : getFactors()) {
            numberProfile += factor + " ";
        }

        return numberProfile;
    }
}
