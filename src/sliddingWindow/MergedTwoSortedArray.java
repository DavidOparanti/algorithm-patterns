package sliddingWindow;

import java.util.Arrays;

//given two sorted arrays, implement the int[] mergeArrays(int[] arr1, int[] arr2) method, which returns
// an array consisting of all elements of both arrays in a sorted order.
public class MergedTwoSortedArray {

    static int[] mergeArrays(int[] arr1, int[] arr2) {

        int arr1Length = arr1.length;
        int arr2Length = arr2.length;


        int[] mergedArray = new int[arr1Length + arr2Length];

        int arr1Index = 0;
        int arr2Index = 0;
        int mergedIndex = 0;

        while (arr1Index < arr1Length && arr2Index < arr2Length) {
             if (arr1[arr1Index] < arr2[arr2Index]) {
                mergedArray[mergedIndex++] = arr1[arr1Index++];
            } else
                mergedArray[mergedIndex++] = arr2[arr2Index++];
           }

        while (arr1Index < arr1.length) {
            mergedArray[mergedIndex++] = arr1[arr1Index++];
        }

        while (arr2Index < arr2.length) {
            mergedArray[mergedIndex++] = arr2[arr2Index++];
        }

        return mergedArray;
    }
        public static void main(String[] args) {
            int[] arrTwo = {1, 2, 3, 4, 5};
            int[] arrOne = {4,6, 7, 9, 10};

            System.out.println( Arrays.toString(mergeArrays(arrOne, arrTwo)) );
    }
}
