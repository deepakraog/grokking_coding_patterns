package drg.grokking.slidingwindow;

public class MinSizeSubArraySum {

	public static int findMinSubArray(int S, int[] arr) {
		int subArraySum = 0;
		int minSubArrayLength = Integer.MAX_VALUE;
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			subArraySum += arr[windowEnd];
			while (subArraySum >= S) {
				minSubArrayLength = Math.min(minSubArrayLength, windowEnd - windowStart + 1);
				subArraySum -= arr[windowStart];
				windowStart++;
			}
		}

		return minSubArrayLength == Integer.MAX_VALUE ? 0 : minSubArrayLength;
	}

	public static void main(String[] args) {
		int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
		System.out.println("Smallest subarray length: " + result);

	}

}
