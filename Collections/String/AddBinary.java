/*
Description
	Given two binary strings a and b, return their sum as a binary string.

Example-1

```
Input: a = "11", b = "1"
Output: "100"
```

Tags
Bit Manipulation, Math, String, Simulation

Solution
Simulation, String
 */
class Solution {
	public String addBinary(String a, String b) {
		StringBuilder ans = new StringBuilder();
		int carry = 0;
		int ptr1 = a.length() - 1, ptr2 = b.length() - 1;

		while (ptr1 >= 0 || ptr2 >= 0) {
			carry += ptr1 >= 0 ? (a.charAt(ptr1) - '0') : 0;
			carry += ptr2 >= 0 ? (b.charAt(ptr2) - '0') : 0;

			ans.append((char) (carry % 2 + '0'));
			carry /= 2;

			ptr1--;
			ptr2--;
		}

		if (carry > 0) {
			ans.append('1');
		}
		ans = ans.reverse();
		return ans.toString();
	}
}
