class Solution {
	public int findMinMoves(int[] machines) {
		int sum = 0;

		for (int i = 0; i < machines.length; i++) {
			sum += machines[i];
		}

		if (sum % machines.length != 0) {
			return -1;
		}

		int ans = 0, preSum = 0, avg = sum / machines.length;

		for (int num : machines) {
			num -= avg;
			preSum += num;
			ans = Math.max(ans, Math.max(Math.abs(preSum), num));
		}

		return ans;
	}
}