/*
Description
	Let the function f(s) be the frequency of the lexicographically smallest character in a non-empty string s. For example, if s = "dcce" then f(s) = 2 because the lexicographically smallest character is 'c', which has a frequency of 2.
	You are given an array of strings words and another array of query strings queries. For each query queries[i], count the number of words in words such that f(queries[i]) < f(W) for each W in words.
	Return an integer array answer, where each answer[i] is the answer to the ith query.

Example-1:

```
Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
```

Example-2:

```
Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
```
 */
class Solution {
	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] res = new int[queries.length];
		Map<String, Integer> map = new HashMap<>();
		int[] cnt = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			cnt[i] = getFrequency(words[i]);
		}

		for (int i = 0; i < queries.length; i++) {
			int f = getFrequency(queries[i]);
			for (int j = 0; j < cnt.length; j++) {
				if (f < cnt[j]) {
					res[i]++;
				}
			}
		}

		return res;
	}

	private int getFrequency(String str) {
		int[] cnt = new int[26];
		for (char ch : str.toCharArray()) {
			cnt[(int) (ch - 'a')]++;
		}

		for (int i = 0; i < 26; i++) {
			if (cnt[i] > 0) {
				return cnt[i];
			}
		}
		return 0;
	}
}
