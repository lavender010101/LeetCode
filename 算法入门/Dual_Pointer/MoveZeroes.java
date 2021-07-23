/*
Description
	Given an integer array `nums`, move all `0` to the end of it while maintaining the relative order of the non-zero elements.
 */

class Solution {
	/* Cover the front of array and append enough zeroes. */
	public void moveZeroes(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[count++] = nums[i];
		}
		for (int i = count; i < nums.length; i++)
			nums[i] = 0;
	}

	/* With two pointer. */
	public void method2(int[] nums) {
		int left = 0, right = 0, tmp;
		while (right < nums.length) {
			if (nums[right] != 0) {
				tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
			}
			right++;
		}
	}
}
