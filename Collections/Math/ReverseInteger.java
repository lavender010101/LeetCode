/*
Description
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example-1

```
Input: x = 1534236469
Output: 0
```

Example-2

```
Input: x = 120
Output: 21
```
 */
class Solution {
	public int reverse(int x) {
		int ans = 0;

		while (x != 0) {
			if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
				return 0;
			}

			ans = ans * 10 + x % 10;
			x /= 10;
		}

		return ans;
	}
}
