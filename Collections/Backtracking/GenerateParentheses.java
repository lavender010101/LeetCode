/*
Description
	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
```

Example 2:

```
Input: n = 1
Output: ["()"]
```

Tags
String, Dynamic Programming, Backtracking

Solution
Backtracking
 */
class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		backtrack(res, new StringBuilder(), 0, 0, n);
		return res;
	}

	void backtrack(List<String> list, StringBuilder curr, int left, int right, int maxn) {
		if (curr.length == maxn * 2) {
			list.add(curr.toString());
			return ;
		}

		if (left < maxn) {
			curr.append('(');
			backtrack(list, curr, left + 1, right, maxn);
			curr.deleteCharAt(curr.length() - 1);
		}

		// only append ')' when the bracket is not close
		if (right < left) {
			curr.append(')');
			backtrack(list, curr, left, right + 1, maxn);
			curr.deleteCharAt(curr.length() - 1);
		}
	}
}
