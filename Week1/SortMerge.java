/*
 * SortMerge
 * 
 * Version 1.0
 * 
 * No Copyright
 */
package com.github.asandyz.sorting;

/**
 * SortMerge class sorts the given array of unsorted integers with the help
 * of helper methods using sort method.
 * 
 * @author  Sandeep Lakka
 * @version 1.0
 * @since 27-09-2016
 * 
 */
public class SortMerge{
    private int[] array;
    private int[] tempArray;
    private int length;
    /**
     * Sorts the given unsorted array of arbitrary length.
     * Uses Mergesort algorithm to sort the contents.
     * 
     * @param array unsorted array of integers of arbitrary length 
     * [ can be zero length]
     * @return Nothing, but side effect is the array passed in will be sorted.
     * 
     */
    public void sort(int[] array){
        this.array = array;
        this.length = array.length;
        this.tempArray = new int[length];
        
        //Call Mergesort subroutine
        doSortMerge(0,length-1);
    }
    
    /**
     * Uses the Conquer-and-Divide approach of merge sort to divide the given
     * array into two halves,sorting the sub-arrays and merging the sorted 
     * sub-arrays.
     * @param low Lower index of the array (starting index of sub-array)
     * @param high Higher index of the array (ending index of sub-array)
     * @returns Nothing, but the side effect is the array from low to high indices
     * is sorted.
     */
    private void doSortMerge(int low, int high){
        //Gaurd condition to stop recursively calling itself
        if(low < high) {
            int middle = low + (high - low)/2;
            //Sort first half
            doSortMerge(low,middle);
            //Sort second half
            doSortMerge(middle+1,high);
            //Merge two parts
            mergeHalves(low,middle,high);
        }
    }
    
    /**
     * Does the merging of two sub-arrays with index limits low to middle and
     * middle+1 to high.
     * 
     * @param low Lower index of array
     * @param middle middle index of low and high
     * @param high higher index of array
     * @returns Nothing
     */
    private void mergeHalves(int low, int middle, int high){
        int i = low;
        int j = middle+1;
        int k = low;

        for(int l = low;l <=high;l++){
            this.tempArray[l] = this.array[l]; //deep copy of the array 'array'
        }
        while(i <=middle && j <=high){
            if(tempArray[i] <= tempArray[j]){
                array[k] = tempArray[i];
                i++;
            }else{
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while(i <= middle){
            array[k] = tempArray[i];
            k++;
            i++;
        }
    }
}
