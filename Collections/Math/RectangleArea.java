/*
Description
	Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
	The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
	The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

Example-1

```
Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
Output: 45
```

Tags
Geometry, Math 

Solution
Geometry
 */

class Solution {
	public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
		int sum = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
		// min{ax2, bx2} is the right edge of coverArea, and max{ax1, bx1} is the left
		// edge
		int coverWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
		// min{ay2, by2} is the top and max{ay1, by1} is the bottom
		int coverHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
		int coverArea = Math.max(coverWidth, 0) * Math.max(coverHeight, 0);
		return sum - coverArea;
	}
}
