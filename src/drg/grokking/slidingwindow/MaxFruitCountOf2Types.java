package drg.grokking.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char rightChar = arr[windowEnd];
            fruitFrequencyMap.put(rightChar, fruitFrequencyMap.getOrDefault(rightChar, 0) + 1);

            if (fruitFrequencyMap.size() > 2) {
                char leftChar = arr[windowStart++];
                fruitFrequencyMap.put(leftChar, fruitFrequencyMap.get(leftChar) - 1);
                if (fruitFrequencyMap.get(leftChar) == 0) {
                    fruitFrequencyMap.remove(leftChar);
                }
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
