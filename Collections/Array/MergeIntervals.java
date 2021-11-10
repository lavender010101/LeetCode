/*
Description
	Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```

Example 2:

```
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

Tags
Array, Sort

Solution
Sort
 */
class Solution {
	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0) {
			return new int[0][];
		}

		List<int[]> res = new ArrayList<>();
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int length = intervals.length;
		int left = intervals[0][0], right = intervals[0][1];
		for (int i = 1; i < length; i++) {
			if (right < intervals[i][0]) {
				res.add(new int[] { left, right });
				left = intervals[i][0];
				right = intervals[i][1];
				continue;
			}

			right = Math.max(right, intervals[i][1]);
		}
		res.add(new int[] { left, right });

		return res.toArray(new int[0][]);
	}
}
