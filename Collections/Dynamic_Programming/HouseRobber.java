/*
Description
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example-1

```
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
```

Example-2

```
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
```
 */
class Solution {
	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return nums[0] > nums[1] ? nums[0] : nums[1];
		}

		int length = nums.length;
		nums[2] += nums[0];

		for (int i = 3; i < length; i++) {
			nums[i] += nums[i - 2] > nums[i - 3] ? nums[i - 2] : nums[i - 3];
		}

		return nums[length - 1] > nums[length - 2] ? nums[length - 1] : nums[length - 2];
	}
}
