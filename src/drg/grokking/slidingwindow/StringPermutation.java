package drg.grokking.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for(char ch : pattern.toCharArray())
            characterFrequencyMap.put(ch, characterFrequencyMap.getOrDefault(ch, 0) + 1);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (characterFrequencyMap.containsKey(rightChar)) {
                characterFrequencyMap.put(rightChar, characterFrequencyMap.get(rightChar) - 1);
                if (characterFrequencyMap.get(rightChar) == 0)
                    matched++;
            }

            if (matched == characterFrequencyMap.size())
                return true;

            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (characterFrequencyMap.containsKey(leftChar)) {
                    if (characterFrequencyMap.get(leftChar) == 0)
                        matched--;
                    characterFrequencyMap.put(leftChar, characterFrequencyMap.get(leftChar) + 1);
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
    }
}
