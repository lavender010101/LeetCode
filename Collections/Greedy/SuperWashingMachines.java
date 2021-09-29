/*
Description
	You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
	For each move, you could choose any m (1 <= m <= n) washing machines, and pass one dress of each washing machine to one of its adjacent washing machines at the same time.
	Given an integer array machines representing the number of dresses in each washing machine from left to right on the line, return the minimum number of moves to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.

Example-1

```
Input: machines = [1,0,5]
Output: 3
Explanation:
1st move:    1     0 <-- 5    =>    1     1     4
2nd move:    1 <-- 1 <-- 4    =>    2     1     3
3rd move:    2     1 <-- 3    =>    2     2     2
```

Example-2

```
Input: machines = [0,3,0]
Output: 2
Explanation:
1st move:    0 <-- 3     0    =>    1     2     0
2nd move:    1     2 --> 0    =>    1     1     1
```

Tags
Greedy, Array

Solution 
Greedy
 */

class Solution {
	public int findMinMoves(int[] machines) {
		int sum = 0;

		for (int i = 0; i < machines.length; i++) {
			sum += machines[i];
		}

		if (sum % machines.length != 0) {
			return -1;
		}

		int ans = 0, preSum = 0, avg = sum / machines.length;

		for (int num : machines) {
			num -= avg;
			preSum += num; // steps from begin to machines[i]
			// find the max step in all machines
			ans = Math.max(ans, Math.max(Math.abs(preSum), num));
		}

		return ans;
	}
}