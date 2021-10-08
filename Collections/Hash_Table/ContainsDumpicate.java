import java.util.Arrays;
import java.util.HashMap;

/*
Description
	Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example-1

```
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
```

Tags
Array, Hash Table, Sorting

Solution
Hash Table
*/
class Solution {
	// Hash Table
	// public boolean containsDumplicate(int[] nums) {
	// HashMap<Integer, Integer> map = new HashMap<>();

	// for (int i = 0; i < nums.length; i++) {
	// if (map.get(nums[i]) != null) {
	// return true;
	// } else {
	// map.put(nums[i], 1);
	// }
	// }

	// return false;
	// }

	// Sorting
	public boolean containsDumplicate(int[] nums) {
		Arrays.sort(nums);

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				return true;
			}
		}

		return false;
	}
}
