import java.util.List;

/*
Description
  Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1
Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"

Example 2
Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"
*/

class Solution {
	public String findLongestWord(String s, List<String> dictionary) {
		String ans = "";

		for (String word : dictionary) {
			int i = 0, j = 0;
			while (i < s.length() && j < word.length()) {
				if (s.charAt(i) == word.charAt(j)) {
					j++;
				}
				i++;
			}

			if (j == word.length()) {
				if (j > ans.length() || (j == ans.length() && word.compareTo(ans) < 0)) {
					ans = word;
				}
			}
		}

		return ans;
	}
}
