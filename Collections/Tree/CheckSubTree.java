/*
Description
	T1 and T2 are two very large binary trees. Create an algorithm to determine if T2 is a subtree of T1.
	A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.

Example-1

```
Input: t1 = [1, 2, 3], t2 = [2]
Output: true
```

Example-2

```
Input: t1 = [1, null, 2, 4], t2 = [3, 2]
Output: false
```

Tags
Tree, Depth-First Search, Binary Tree, String Matching, Hash Function
 */

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *	int val;
 * 	TreeNode left;
 * 	TreeNode right;
 * 
 * 	TreeNode(int x) {
 * 		val = x;
 * 	}
 * }
 */

/**
 * Solution-1 : Recursion
 * Time : 1ms
 * Mem : 43.7 MB
 */
class Solution1 {
	public boolean checkSubTree(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true;
		}

		if (t1 == null) {
			return false;
		}

		return equals(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
	}

	public boolean equals(TreeNode t1, TreeNode t2) {
		if (t1 == t2) {
			return true;
		}

		if (t1 == null || t2 == null) {
			return false;
		}

		return t1.val == t2.val && equals(t1.left, t2.left) && equals(t1.right, t2.right);
	}
}

/**
 * Solution-2 : KMP
 * Time : 11ms
 * Mem : 46.3MB
 */
class Solution2 {
	public boolean checkSubTree(TreeNode t1, TreeNode t2) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();

		preTraversal(t1, list1);
		preTraversal(t2, list2);

		return kmp(list1, list2);
	}

	// Convert tree to list
	public void preTraversal(TreeNode root, List<String> list) {
		if (root == null) {
			list.add("null");
			return;
		}

		list.add(root.val + "");

		preTraversal(root.left, list);
		preTraversal(root.right, list);
	}

	// Matching
	public boolean kmp(List<String> t1, List<String> t2) {
		int last = t2.size(), size = t1.size();
		int[] status = new int[last];
		status[0] = -1;

		for (int i = 1, j = -1; i < last; i++) {
			while (j != -1 && !t2.get(j + 1).equals(t2.get(i))) {
				j = status[j];
			}

			if (t2.get(j + 1).equals(t2.get(i))) {
				j++;
			}

			status[i] = j;
		}

		for (int i = 0, j = -1; i < size; i++) {
			while (j != -1 && !t2.get(j + 1).equals(t1.get(i))) {
				j = status[j];
			}

			if (t2.get(j + 1).equalst1.get(i)) {
				j++;
			}

			if (j + 1 == last) {
				return true;
			}
		}

		return false;
	}
}
