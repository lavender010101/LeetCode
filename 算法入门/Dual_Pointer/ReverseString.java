/*
Description
	Write a function that reverses a string. The input string is given as an array of characters `s`.

Example 1:
```
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
```
 */

class Solution {
	public void reverseString(char[] s) {
		int left = 0, right = s.length - 1;
		char tmp;
		while (left < right) {
			tmp = s[left];
			s[left] = s[right];
			s[right] = tmp;
			left++;
			right--;
		}
	}
}
