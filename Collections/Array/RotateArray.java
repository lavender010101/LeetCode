/*
Description
	Given an array, rotate the array to the right by k steps, where k is non-negative.

Example-1

```
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

Tags
Array, Math, Two Pointers
*/

class Solution {
	public void rotate(int[] nums, int k) {
		k %= nums.length;
		// the reverse can move item by saving space
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	private void reverse(int[] arr, int beg, int end) {
		while (beg < end) {
			arr[beg] = arr[beg] ^ arr[end];
			arr[end] = arr[beg] ^ arr[end];
			arr[beg] = arr[beg] ^ arr[end];
			beg++;
			end--;
		}
	}
}
