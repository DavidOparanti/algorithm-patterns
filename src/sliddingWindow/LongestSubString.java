package sliddingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    static int getLongestSubstring(String str) {
        int max = 0;
        int count = 0;


        Map<Character, Integer> accum = new HashMap<>();

        for (int length = 0; length < str.length(); length++) {
            Character currentChar = str.charAt(length);


            if (accum.containsKey(currentChar)) {
                count = Math.max(count, accum.get(currentChar) + 1);
            }
            accum.put(currentChar, length);

            max = Math.max(max, length - count + 1);
        }
        return max;
    }

        public static int[] withdraw(int amount) {
            int numOfHundredBills = 0;
            int numOfFiftyBills = 0;
            int numOfTwentyBills = 0;

            while (amount > 0) {
                if (amount % 100 == 0) {
                    numOfHundredBills++;
                    amount -= 100;
                } else if (amount % 50 == 0) {
                    numOfFiftyBills++;
                    amount -= 50;
                } else {
                    numOfTwentyBills++;
                    amount -= 20;
                }
            }

            return new int[]{numOfHundredBills, numOfFiftyBills, numOfTwentyBills};
        }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(withdraw(25)));
//        System.out.println(getLongestSubstring("opeyemiabcdefghijklmn"));
    }

}
