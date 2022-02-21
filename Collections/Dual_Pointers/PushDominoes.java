/*
Description
    There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the rig
    After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the rig
    When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forc
    For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domi
    You are given a string dominoes representing the initial state whe
		* dominoes[i] = 'L', if the ith domino has been pushed to the left,
		* dominoes[i] = 'R', if the ith domino has been pushed to the right, and
		* dominoes[i] = '.', if the ith domino has not been pushed.
    Return a string representing the final state.

Exaple-1:

```
Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
```

Example-2:
![example-2](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/05/18/domino.png)

```
Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
```

Tags
Two Pointers, String, Dynamic Programming
 */
class Solution {
	public String pushDominoes(String dominoes) {
		char[] ch = dominoes.toCharArray();
		Deque<int[]> queue = new ArrayDeque<>();
		int length = ch.length;
		int[] status = new int[length];

		for (int i = 0; i < length; i++) {
			if (ch[i] == '.') {
				continue;
			}

			int direct = ch[i] == 'L' ? -1 : 1;
			queue.add(new int[] { i, 1, direct });
			status[i] = 1;
		}

		while (!queue.isEmpty()) {
			int[] info = queue.poll();
			int loc = info[0], time = info[1], direct = info[2], idx = loc + direct;

			if (ch[loc] == '.' || (idx < 0 || idx >= length)) {
				continue;
			}

			if (status[idx] == 0) {
				queue.add(new int[] { idx, time + 1, direct });
				status[idx] = time + 1;
				ch[idx] = direct == -1 ? 'L' : 'R';
			} else if (status[idx] == time + 1) {
				ch[idx] = '.';
			}
		}

		return String.valueOf(ch);
	}
}
