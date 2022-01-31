/*
Description
	A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
	Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.

Example-1:

```
Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.
```

Example-2:

```
Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
```

Example-3:

```
Input: s = "c"
Output: ""
Explanation: There are no nice substrings.
```

Tags
Bit Manipulation, Hash Table, String, Sliding Window
 */
class Solution {
	public String longestNiceSubstring(String s) {
		int length = s.length();
		int maxPos = 0, maxLength = 0;
		for (int i = 0; i < length; i++) {
			int lower = 0, upper = 0;
			for (int j = i; j < length; j++) {
				char c = s.charAt(j);
				if (c >= 'a' && c <= 'z') {
					lower |= 1 << (c - 'a');
				} else {
					upper |= 1 << (c - 'A');
				}

				if (lower == upper && j - i + 1 > maxLength) {
					maxPos = i;
					maxLength = j - i + 1;
				}
			}
		}

		return s.substring(maxPos, maxPos + maxLength);
	}
}
