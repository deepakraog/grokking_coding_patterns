package drg.grokking.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    // Time Complexity O(n + n) ~ O(n)
    // SPace Complexity O(k)
    public static int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            characterFrequencyMap.put(rightChar, characterFrequencyMap.getOrDefault(rightChar, 0) + 1);

            if (characterFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart++);
                characterFrequencyMap.put(leftChar, characterFrequencyMap.get(leftChar) - 1);
                if (characterFrequencyMap.get(leftChar) == 0) {
                    characterFrequencyMap.remove(leftChar);
                }
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
