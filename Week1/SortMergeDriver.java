/*
 * SortMergeDriver
 * 
 * Version 1.0
 * 
 * No Copyright
 */
package com.github.asandyz.sorting;

import java.util.Random; // Random class utility is used in populating input array
import java.util.Arrays; // Arrays class utility is used in printing unsorted and sorted array
/**
 * SortMergeDriver
 * 
 * Driver program for the Class SortMerge
 * Takes in input a number, which will be the length of input array to sort
 * input array is populated with random values.
 * 
 */
public class SortMergeDriver {
    /**
     * Main method takes in integer 'x' as command-line argument and parses it
     * integer which is taken as length of array. 
     * Array is populated with random numbes from 1 to 'x' ('x' is args[0])
     * Duplicate values are possible, as random is used.
     * @param args int which will be length of input array for sorting.
     */
    public static void main(String[] args){
        Random rand = new Random();
        int num = Integer.parseInt(args[0]);
        int[] array = new int[num];
        for(int i = 0 ; i <num; i++){
            array[i] = rand.nextInt(num) + 1;
        }
        System.out.println("Unsorted array");
        System.out.println(Arrays.toString(array));
        long startTime = System.currentTimeMillis();
        //Sorts the array 'array'
        new SortMerge().sort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(array));
        //Check for the correctness of sort
        boolean res = true;
        for(int i =1; i < num; i++){
            if( array[i-1] > array[i]){
                res = false;
            }
        }
        // Something bad has happend! :(
        if(!res) System.out.println("Array is not sorted!");
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
        System.out.println("That took " + (double)(endTime - startTime)/1000 + " seconds");
    }
}
