/*
Description
   Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
   The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

Example-1

```
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
```

Tags
Tree, Depth-First Search, Binary Tree
*/
class Solution {
	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return 0;
		}
		int ans = 0;

		ans += countTargetNum(root, targetSum);
		// Attention: here start a new counting from root's children
		// Do not call countTargetNum(child, targetSum)
		ans += pathSum(root.left, targetSum);
		ans += pathSum(root.right, targetSum);

		return ans;
	}

	private int countTargetNum(TreeNode root, int targetSum) {
		if (root == null) {
			return 0;
		}

		int cnt = 0;
		if (root.val == targetSum) {
			cnt++;
		}

		cnt += countTargetNum(root.left, targetSum - root.val);
		cnt += countTargetNum(root.right, targetSum - root.val);

		return cnt;
	}
}

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
