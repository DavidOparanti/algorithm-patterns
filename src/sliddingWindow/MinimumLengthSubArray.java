package sliddingWindow;

//Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest
//contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
//        Example 1:
//        Input: [2, 1, 5, 2, 3, 2], S=7
//        Output: 2
//        Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
public class MinimumLengthSubArray {

    static int minimumLengthSubArray(int[] arr, int k) {
        int minLength = Integer.MAX_VALUE;
        int subSum = 0;
        int startIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            subSum += arr[i];

            while (subSum >= k) {
                minLength = Math.min(minLength, i - startIndex + 1);
                subSum -= arr[startIndex];
                startIndex++;
            }
        }
        return  minLength;
    }

    public static void main(String[] args) {
        System.out.println(minimumLengthSubArray(new int[] {2, 1, 5, 2, 3, 2}, 7));
        System.out.println(minimumLengthSubArray(new int[] {3, 4, 1, 1, 6}, 8));
        System.out.println(minimumLengthSubArray(new int[] {2, 1, 5, 2, 8}, 7));
    }
}
