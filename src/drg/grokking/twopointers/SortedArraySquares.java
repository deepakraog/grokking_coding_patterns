package drg.grokking.twopointers;

import java.util.Arrays;

public class SortedArraySquares {
    // Time Complexity O(n)
    // Space Complexity O(n)
    public static int[] makeSquares(int[] arr) {
        int highestSquareIdx = arr.length -1;
        int[] squares = new int[arr.length];
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        System.out.println(Arrays.toString(result));
        int[] result2 = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        System.out.println(Arrays.toString(result2));
    }
}
