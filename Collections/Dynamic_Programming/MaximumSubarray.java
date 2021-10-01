/*
Description
	Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	A subarray is a contiguous part of an array.

Example-1

```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

Tags
Array, Divide and Conquer, Dynamic Programming

Solution
Dynamic Programming
 */
class Solution {
	public int maxSubArray(int[] nums) {
		int ans = nums[0], tmpMax = 0;

		for (int i = 0; i < nums.length; i++) {
			// if tmpMax < 0, begin a new subarray, else continue
			tmpMax = tmpMax < 0 ? nums[i] : tmpMax + nums[i];
			ans = tmpMax > ans ? tmpMax : ans;
		}

		return ans;
	}
}
