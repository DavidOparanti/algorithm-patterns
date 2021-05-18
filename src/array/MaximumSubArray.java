package array;

//        Given an array of positive numbers and a positive number ‘k,’
//        find the maximum sum of any contiguous subarray of size ‘k’.
//
//        Example 1:
//
//        Input: [2, 1, 5, 1, 3, 2], k=3
//        Output: 9
//        Explanation: Subarray with maximum sum is [5, 1, 3].


public class MaximumSubArray {

    static int maximumSubArray(int[] arr, int k) {
        int highestSum = 0;
        int subSum = 0;
        int startIndex = 0;

        for (int endIndex = 0; endIndex < arr.length; endIndex++) {
            subSum += arr[endIndex];

            if (endIndex >= k -1) {
               highestSum = Math.max(highestSum, subSum);
               subSum -= arr[startIndex++];
            }
        }
        return highestSum;
    }

    public static void main(String[] args) {
        System.out.println(maximumSubArray(new int[] {2, 1, 5, 1, 3, 2}, 3));
    }
}
