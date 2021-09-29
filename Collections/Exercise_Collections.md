
#### [21.Merge Two Sorted Lists](https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/)

##### Description
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

##### Example-1

```
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
```
##### Definition for singly-linked list

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
    	this.val = val; 
    }
    ListNode(int val, ListNode next) { 
    	this.val = val;
    	this.next = next; 
    }
}

```

* Solution-1 Recursion
```java
class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if(l2 == null) {
			return l1;
		} else if (l1.val <= l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
```

* Solution-2 Dual pointer

```java
class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode ans = new ListNode(0, null);
		ListNode tmp = ans;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tmp.next = l1;
				l1 = l1.next;
			}
			else {
				tmp.next = l2;
				l2 = l2.next;
			}
			tmp = tmp.next;
		}

		tmp.next = l1 == null ? l2 : l1;

		return ans.next;
	}
}
```


#### [524.Longest Word in Dictionary through Deleting](https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/)
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





