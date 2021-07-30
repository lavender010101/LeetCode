/* ====================================================
 *   Copyright (C) 2021  All rights reserved.
 *
 *   Author        : lavender010101
 *   Email         : lavender010101@163.com
 *   File Name     : MiddleOfTheLinkedList.java
 *   Last Modified : 2021-07-30 23:22
 *   Describe      : 
 *
 * ==================================================== */

/*
Description
	Given the `head` of a singly linked list, return *the middle node of the linked list*.
	If there are two middle nodes, return **the second middle** node.

Example 1:
```
Input: head = [1, 2, 3, 4, 5]
Output: [3, 4, 5]
Explanation: The middle node of the list is node 3.
```
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode middleNode(ListNode head) {
		ListNode middle, last;
		middle = head;
		last = head;
		if (last.next == null)
			return middle;
		if (nextSecondNode(last) == null)
			return head.next;
		while (last.next != null) {
			middle = middle.next;
			last = nextSecondNode(last);
			if (last == null)
				break;
		}
		return middle;
	}

	public ListNode nextSecondNode(ListNode node) {
		if (node.next == null)
			return null;
		return node.next.next;
	}
}
