/*
Description
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Example-1

```
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

Tags
Recursion, Linked List

Solution
Dual pointer
 */

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