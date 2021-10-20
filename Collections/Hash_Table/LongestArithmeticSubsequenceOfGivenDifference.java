/*
Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.

Example 1:

```
Input: arr = [1,2,3,4], difference = 1
Output: 4
Explanation: The longest arithmetic subsequence is [1,2,3,4].
```

Example 2:

```
Input: arr = [1,3,5,7], difference = 1
Output: 1
Explanation: The longest arithmetic subsequence is any single element.
```

Tags
Array, Hash Table, Dynamic Programming

Solution
Hash Table
 */
class Solution {
	public int longestSubsequence(int[] arr, int difference) {
		Map<Integer, Integer> map = new HashMap<>();
		Integer len = null;
		int ans = 1;
		for (int i = 0; i < arr.length; i++) {
			len = map.get(arr[i] - difference);
			if (len != null) {
				map.put(arr[i], len + 1);
				ans = len + 1 > ans ? len + 1 : ans;
			} else {
				map.put(arr[i], 1);
			}
		}
		return ans;
	}
}
