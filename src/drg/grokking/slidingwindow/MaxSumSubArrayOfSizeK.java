package drg.grokking.slidingwindow;

import java.util.Arrays;

public class MaxSumSubArrayOfSizeK {

	public static int findMaxSumSubArray(int k, int[] arr) {
		int[] subArray = new int[k];
		int[] windowArray = new int[k];
		int maxSum = 0;
		int windowSum;

		for (int i = 0; i <= arr.length - k; i++) {
			windowSum = 0;
			for (int j = i, index = 0; j < i + k; j++) {
				windowSum += arr[j];
				windowArray[index++] = arr[j];
			}

			if (maxSum < windowSum) {
				subArray = windowArray;
			}
			windowArray = Arrays.copyOfRange(windowArray, 1, windowArray.length + 1);
			maxSum = Math.max(maxSum, windowSum);

		}

		System.out.println("SubArray with max sum is " + Arrays.toString(subArray));
		return maxSum;
	}

	public static int findMaxSumSubArraySlidWin(int k, int[] arr) {
		int[] subArray = new int[k];
		int[] windowArray = new int[k];
		int[] initialArray = new int[k];

		int maxSum = 0;
		int windowSum = 0;
		int windowStart = 0;
		int initialSum = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];

			if (windowEnd < k) {
				windowArray[windowEnd] = arr[windowEnd];
				initialSum += arr[windowEnd];
				initialArray = windowArray;
			}

			if (windowEnd >= k) {
				windowSum -= arr[windowStart++];
				windowArray = Arrays.copyOfRange(windowArray, 1, windowArray.length + 1);
				if (maxSum <= windowSum) {
					windowArray[k - 1] = arr[windowEnd];
					subArray = windowArray;
				}
				maxSum = Math.max(maxSum, windowSum);
			}
		}

		if (initialSum >= maxSum) {
			subArray = initialArray;
			maxSum = initialSum;
		}

		System.out.println("SubArray with max sum is " + Arrays.toString(subArray));
		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, 5, 11, 3, 2 };
		//int[] arr = { 2, 3, 4, 8, 1, 5 };
		System.out.println("MAX Sum of Sub Array " + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, arr));
		System.out.println("MAX Sum of Sub Array via sliding window technique "
				+ MaxSumSubArrayOfSizeK.findMaxSumSubArraySlidWin(2, arr));
	}

}
