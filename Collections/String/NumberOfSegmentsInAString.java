/*
Description
	You are given a string s, return the number of segments in the string. 
	A segment is defined to be a contiguous sequence of non-space characters.

Example-1

```
Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
```
 */

class Solution {
	public int countSegments(String s) {
		int ans = 0;

		for (int i = 0; i < s.length(); i++) {
			// count the first letter of words
			if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
				ans++;
			}
		}

		return ans;
	}
}
