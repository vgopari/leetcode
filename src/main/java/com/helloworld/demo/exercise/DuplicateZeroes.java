package com.helloworld.demo.exercise;

import java.util.Arrays;

public class DuplicateZeroes {

    public static void main(String[] args) {
        duplicateZeros(new int[]{1, 0, 0, 2, 3});
    }

    public static void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    System.out.println("arr1:" + Arrays.toString(arr));
                    arr[length_] = 0;
                    System.out.println("arr2:" + Arrays.toString(arr));
                    length_ -= 1;
                    break;

                }
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length_ - possibleDups;
        System.out.println("possibleDups " + possibleDups);
        System.out.println("length_ " + length_);
        System.out.println("last " + last);
        // Copy zero twice, and non zero once.
        System.out.println("arr prev loop: " + Arrays.toString(arr));

        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                System.out.println("possibleDups in  forloop:" + possibleDups);
                System.out.println("arr in loop: " + Arrays.toString(arr));
                arr[i + possibleDups] = 0;
                System.out.println("arr in loop1: " + i + Arrays.toString(arr));
                possibleDups--;
                arr[i + possibleDups] = 0;
                System.out.println("arr in loop2: " +i + Arrays.toString(arr));

            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
        System.out.println("arr: " + Arrays.toString(arr));
    }
}