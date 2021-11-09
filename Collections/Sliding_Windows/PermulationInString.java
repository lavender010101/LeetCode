/*
Description
	Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
	In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

```
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
```

Example 2:

```
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
```

Constraints:
	1 <= s1.length, s2.length <= 104
	s1 and s2 consist of lowercase English letters.

Tags
Hash Table, Two Pointers, String, Sliding Windows

Solution
Sliding Windows
 */

class Solution {
	public boolean checkInclusion(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 > len2) {
			return false;
		}

		int[] cnt1 = new int[26];
		int[] cnt2 = new int[26];
		for (int i = 0; i < len1; i++) {
			cnt1[s1.charAt(i) - 'a']++;
			cnt2[s2.charAt(i) - 'a']++;
		}

		if (Arrays.equals(cnt1, cnt2)) {
			return true;
		}

		// keep a sliding windows
		for (int i = len1; i < len2; i++) {
			// record the characters in [i - len1, i]
			cnt2[s2.charAt(i) - 'a']++;
			cnt2[s2.charAt(i - len1) - 'a']--;

			if (Arrays.equals(cnt1, cnt2)) {
				return true;
			}
		}

		return false;
	}
}
