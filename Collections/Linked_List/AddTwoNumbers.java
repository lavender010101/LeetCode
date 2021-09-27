/*
Description
	You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example-1

```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
```
 */

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ans = new ListNode(0, null);
		ListNode tmp = ans;
		int carry = 0;

		while (l1 != null && l2 != null) {
			carry = (l1.val + l2.val + tmp.val) / 10;
			tmp.val = (l1.val + l2.val + tmp.val) % 10;

			if (l1.next != null || l2.next != null || carry != 0) {
				tmp.next = new ListNode(carry, null);
				tmp = tmp.next;
				carry = 0;
			}

			l1 = l1.next != null ? l1.next : null;
			l2 = l2.next != null ? l2.next : null;
		}

		// add l1's nodes
		while (l1 != null) {
			carry = (l1.val + tmp.val) / 10;
			tmp.val = (l1.val + tmp.val) % 10;

			if (l1.next != null || carry != 0) {
				tmp.next = new ListNode(carry, null);
				tmp = tmp.next;
				carry = 0;
			}

			l1 = l1.next != null ? l1.next : null;
		}

		// add l2's nodes
		while (l2 != null) {
			carry = (l2.val + tmp.val) / 10;
			tmp.val = (l2.val + tmp.val) % 10;

			if (l2.next != null || carry != 0) {
				tmp.next = new ListNode(carry, null);
				tmp = tmp.next;
				carry = 0;
			}

			l2 = l2.next != null ? l2.next : null;
		}

		return ans;
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
