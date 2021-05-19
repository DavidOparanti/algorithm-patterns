package sliddingWindow;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

//Given an array of characters where each character represents a fruit tree, you are given two baskets, and your goal is
// to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
//
//        You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from
//        each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
//
//        Write a function to return the maximum number of fruits in both baskets.
//
//        Example 1:
//
//        Input: Fruit=['A', 'B', 'C', 'A', 'C']
//        Output: 3
//        Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
//
//        Example 2:
//
//        Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
//        Output: 5
//        Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
//        This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
public class MaxFruitCountOf2Types {

    static int maxFruitCountOf2Types(Character[] array) {
        int maxCount = 0;
        int charCount = 0;

        Map<Character, Integer> accumulator = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            Character currentChar = array[i];
            accumulator.put(currentChar, accumulator.getOrDefault(currentChar, 0) + 1);

            while (accumulator.size() > 2) {
                Character leftChar = array[charCount];
                accumulator.put(leftChar, accumulator.get(leftChar) - 1);
                if (accumulator.get(leftChar) == 0) {
                    accumulator.remove(leftChar);
                }
                charCount++;
            }
            maxCount = Math.max(maxCount, i - charCount + 1);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(maxFruitCountOf2Types(new Character[] {'A', 'B', 'C', 'A', 'C'}));
        System.out.println(maxFruitCountOf2Types(new Character[] {'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
