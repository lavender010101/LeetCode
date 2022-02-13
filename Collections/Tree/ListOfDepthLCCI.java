/*
Description
	Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists). Return a array containing all the linked lists.

Example:

```
Input: [1,2,3,4,5,null,7,8]

        1
       /  \ 
      2    3
     / \    \ 
    4   5    7
   /
  8

Output: [[1],[2,3],[4,5,7],[8]]
```

Tags
Tree, Breadth-First Search, Linked List, Binary Tree
 */
class Solution {
	public ListNode[] listOfDepth(TreeNode tree) {
		if (tree == null) {
			return null;
		}

		ListNode[] res = new ListNode[getDepth(tree, 0)];
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(tree);
		ListNode head = null, curr = null;
		TreeNode node = null;
		int ptr = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				node = queue.poll();

				if (i == 0) {
					head = new ListNode(node.val);
					curr = head;
				} else {
					curr.next = new ListNode(node.val);
					curr = curr.next;
				}

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

			res[ptr++] = head;
		}

		return res;
	}

	public int getDepth(TreeNode root, int depth) {
		if (root == null) {
			return depth;
		}

		int left = getDepth(root.left, depth);
		int right = getDepth(root.right, depth);

		return Math.max(left, right) + 1;
	}
}
