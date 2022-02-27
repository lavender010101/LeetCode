/*
Description
	Write a method to compute all permutations of a string of unique characters.

Example-1:

```
Input: S = "qwe"
Output: ["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
```

Example-2:

```
Input: S = "ab"
Output: ["ab", "ba"]
```

Tags
String, Backtracing
 */
class Solution {
	public String[] permutation(String S) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		boolean[] vis = new boolean[S.length()];

		backtrace(S, list, sb, vis, S.length());

		return list.toArray(new String[list.size()]);
	}

	private void backtrace(String str, List<String> list, StringBuilder sb, boolean[] vis, int length) {
		if (sb.length() == length) {
			list.add(sb.toString());
			return;
		}

		for (int i = 0; i < length; i++) {
			if (vis[i]) {
				continue;
			}

			vis[i] = true;
			sb.append(str.charAt(i));
			backtrace(str, list, sb, vis, length);
			sb.deleteCharAt(sb.length() - 1);
			vis[i] = false;
		}
	}
}
