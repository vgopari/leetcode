package com.helloworld.demo.exercise;

public class NumberOfEvenNumberOfDigits {

    public void method() {
        int nDigits = (int) (Math.floor(Math.log10(Math.abs(01213))) + 1);
        System.out.println(nDigits);
    }

    public static void main(String[] args) {
        int nDigits = (int) (Math.floor(Math.log10(Math.abs(012213))) + 1);
        System.out.println(nDigits);
        int n = 3;
        int count = 0;
        while(n > 0) {
            n = n/10;
            count++;
        }
        System.out.println("Count: " + count);
        System.out.println("n: " + n);
    }
}
