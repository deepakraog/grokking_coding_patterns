package drg.grokking.slidingwindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

	// Time Complexity O(n*k)
	public static double[] findAverages(int k, int[] arr) {
		double result[] = new double[(arr.length - k) + 1];
		for (int i = 0; i <= arr.length - k; i++) {
			double sum = 0;
			for (int j = i; j < k + i; j++) {
				sum += arr[j];
			}
			result[i] = sum / k;
		}

		return result;
	}

	public static double[] findAveragesSlidWind(int k, int[] arr) {
		double result[] = new double[(arr.length - k) + 1];
		double windowSum = 0;
		int windowStart = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];

			if (windowEnd >= k - 1) {
				result[windowStart] = windowSum / k;
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		// AvgSum with brute force - O(n*k) time complexity
		double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
		System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));

		// AvgSum with brute force - O(n*k) time complexity
		result = AverageOfSubarrayOfSizeK.findAveragesSlidWind(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
		System.out
				.println("Averages of subarrays of size K using sliding window technique: " + Arrays.toString(result));
	}

}
