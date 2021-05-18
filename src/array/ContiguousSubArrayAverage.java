package array;

import java.util.ArrayList;
import java.util.List;
//Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
public class ContiguousSubArrayAverage {

    static List<Double> findAverage(int[] arr, int k) {
        double subSum = 0;
        int start = 0;

        List<Double> result = new ArrayList<>();


        for (int end = 0; end < arr.length; end++) {
            subSum += arr[end];

            if(end >= k - 1) {
                result.add(subSum / k);
                subSum -= arr[start++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAverage(new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 }, 5));
    }
}
