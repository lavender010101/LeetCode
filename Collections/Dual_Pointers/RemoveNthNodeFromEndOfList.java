/*
Description
	Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example-1

```
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
```

Example-2

```
Input: head = [1], n = 1
Output: []
```
 */
class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode ans = new ListNode(0, head);
		ListNode pre = ans, end = head;

		for (int i = 0; i < n - 1; i++) {
			end = end.next;
		}

		while (end.next != null) {
			end = end.next;
			pre = pre.next;
		}

		pre.next = pre.next.next; // pre.next must before end
		return ans.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
