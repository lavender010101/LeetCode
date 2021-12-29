/*
Description
	Given an integer array nums of unique elements, return all possible subsets (the power set).
	The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```

Example 2:

```
Input: nums = [0]
Output: [[],[0]]
```

Tags
Bit Manipulation, Array, Backtracking
 */
class Solution {
	List<Integer> list = new ArrayList<>();
	List<List<Integer>> res = new ArrayList<>();

	// public List<List<Integer>> subsets(int[] nums) {
	// int length = nums.length;
	//
	// for (int mask = 0; mask < (1 << length); mask++) {
	// list.clear();
	// for (int i = 0; i < length; i++) {
	// if ((mask & (1 << i)) != 0) {
	// list.add(nums[i]);
	// }
	// }
	//
	// res.add(new ArrayList<Integer>(list));
	// }
	//
	// return res;
	// }

	public List<List<Integer>> subsets(int[] nums) {
		dfs(0, nums);
		return res;
	}

	void dfs(int curr, int[] nums) {
		if (curr = nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}

		list.add(nums[curr]);
		dfs(curr + 1, nums);
		list.remove(list.size() - 1);
		dfs(curr + 1, nums);
	}
}
