
#### 524.Longest Word in Dictionary through Deleting
###### Description
Given a string `s` and a string array `dictionary`, return the *longest string in the dictionary that can be formed by deleting some of the given string characters.* If there is more than one position result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

###### Example-1
```
Input: s = "abpcplea", dictionary = ["ale", "apple", "monkey", "plea"]
Output: "apple"
```

###### Example-2
```
Input: s = "abpcplea", dictionary = ["a", "b", "c"]
Output: "a"
```

###### Constraints
* `1 <= s.length <= 1000`
* `1 <= dictionary.length <= 1000`
* `1 <= dictionary[i].length <= 1000`
* `s` and `dictionary[i]` consist of lowercase English letters.

##### Solution-1:Dual Pointers

```java
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
```



