package drg.grokking.twopointers;

import java.util.HashMap;

public class PairTargetSum {
    public static int[] searchBruteForce(int[] arr, int targetSum) {
        // Time Complexity O(n^2)
        // Space Complexity O(1)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] search(int[] arr, int targetSum) {
        // Time Complexity O(n)
        // Space Complexity O(1)
        int left = 0, right = arr.length - 1, currentSum = 0;
        while (left < right) {
            currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                return new int[]{left, right};
            }

            if (currentSum > targetSum) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] searchViaHashMap(int[] arr, int targetSum) {
        // Time Complexity O(n)
        // Space Complexity O(n)
        HashMap<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i]))
                return new int[] { nums.get(targetSum - arr[i]), i };
            else
                nums.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] result = PairTargetSum.searchBruteForce(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairTargetSum.searchBruteForce(new int[]{2, 5, 9, 11}, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        result = PairTargetSum.search(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairTargetSum.search(new int[]{2, 5, 9, 11}, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        result = PairTargetSum.searchViaHashMap(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairTargetSum.searchViaHashMap(new int[]{2, 5, 9, 11}, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
