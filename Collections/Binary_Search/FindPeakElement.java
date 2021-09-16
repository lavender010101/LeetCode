/*
 * [162.Find Peak Element](https://leetcode-cn.com/problems/find-peak-element/)
 * Description
	A peak element is an element that is strictly greater than its neighbors.
	Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
	You may imagine that nums[-1] = nums[n] = -∞.
	You must write an algorithm that runs in O(log n) time.

 * Expamle 1
	```
	Input: nums = [1,2,3,1]
	Output: 2
	```

 * Expamle 2
	```
	Input: nums = [1,2,1,3,5,6,4]
	Output: 5
	```

 * Expamle 3
	```
	Input: nums = [-2147483648]
	Output: 0
	```
 */

class Solution {
	public int findPeakElement(int[] nums) {
		int ans = 0;
		int length = nums.length;
		int left = 0, right = length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
				ans = mid;
				break;
			}

			if (compare(nums, mid, mid + 1) < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}

	public int get(int[] nums, int index) {
		if (index == -1 || index == nums.length) {
			return -2147483648;
		}

		return nums[index];
	}

	public int compare(int[] nums, int index1, int index2) {
		int num1 = get(nums, index1);
		int num2 = get(nums, index2);
		if (num1 == num2) {
			return 0;
		}

		return num1 > num2 ? 1 : -1;
	}
}
