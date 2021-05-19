package sliddingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        if (str.isBlank()  || str.length() < k)
            throw new IllegalArgumentException();
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char rightChar = str.charAt(i);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            while (window.size() > k) {
                Character lefChar = str.charAt(windowStart);
                window.put(lefChar, window.get(lefChar) -1);
                if (window.get(lefChar) == 0) {
                    window.remove(lefChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, i - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
