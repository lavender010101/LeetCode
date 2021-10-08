/*
	Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
	You must implement a solution with a linear runtime complexity and use only constant extra space.

Example-1

```
Input: nums = [4,1,2,1,2]
Output: 4
```

Tags
Bit Manipulation, Array
 */

class Solution {
	public int singleNumber(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			ans ^= nums[i];
		}

		return ans;
	}
}
