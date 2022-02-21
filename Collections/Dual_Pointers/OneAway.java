/*
Description
	There are three types of edits that can be performed on strings: 
		insert a character;
		remove a character;
		replace a character. 
	Given two strings, write a function to check if they are one edit (or zero edits) away.

Example-1:

```
Input:
first = "pale"
second = "ple"
Output: True
```

Example 2:

```
Input: 
first = "pales"
second = "pal"
Output: False
```

Tags
Two Pointers, String
*/
class Solution {
	public boolean oneEditAway(String first, String second) {
		if (second.length() > first.length()) {
			return oneEditAway(second, first);
		}

		if (first.length() - second.length() > 1) {
			return false;
		}

		char[] str1 = first.toCharArray(), str2 = second.toCharArray();

		int cnt = 0;
		int ptr1 = 0, ptr2 = 0;
		if (str1.length != str2.length) {
			while (ptr1 < str1.length && cnt <= 1) {
				if (str1[ptr1++] != str2[ptr2++]) {
					cnt++;
				}
			}
		} else {
			while (ptr1 < str1.length && cnt <= 1) {
				if (ptr2 == str2.length) {
					return cnt == 0;
				}

				if (str1[ptr1++] == str2[ptr2++]) {
					continue;
				}

				if (ptr1 < str1.length - 1 && str1[++ptr1] == str2[ptr2]) {
					cnt++;
				} else {
					return false;
				}

			}
		}

		return cnt <= 1;
	}
}
