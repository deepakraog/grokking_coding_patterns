package drg.grokking.slidingwindow;

import java.util.Arrays;

public class MaxSumSubArrayOfSizeK {

	public static int findMaxSumSubArray(int k, int[] arr) {
		int[] subArray = new int[k];
		int[] windowArray = new int[k];
		int maxSum = 0;

		for (int i = 0; i < arr.length - k; i++) {
			int windowSum = 0;
			for (int j = i, index = 0; j < i + k; j++) {
				windowSum += arr[j];
				windowArray[index++] = arr[j];
			}

			if (windowSum > maxSum) {
				maxSum = windowSum;
				subArray = windowArray;
				windowArray = new int[k];
				windowSum = 0;
			}
		}

		System.out.println("SubArray with max sum is " + Arrays.toString(subArray));
		return maxSum;
	}

	public static void main(String[] args) {
		//int[] arr = { 2, 6, 5, 1, 3, 2 };
		int[] arr = {2, 3, 4, 1, 5};
		System.out.println("MAX Sum of Sub Array " + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, arr));
	}

}
