class Solution {
	static String[] nums = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine" };
	static int[] priority = new int[] { 0, 8, 6, 3, 2, 7, 5, 9, 4, 1 };

	public String originalDigits(String s) {
		int length = s.length();
		int[] cnts = new int[26];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++) {
			cnts[s.charAt(i) - 'a']++;
		}

		for (int i : priority) {
			int minn = Integer.MAX_VALUE;
			char[] num = nums[i].toCharArray();
			// count the minimal in num
			for (char c : num) {
				minn = Math.min(minn, cnts[c - 'a']);
			}

			for (char c : num) {
				cnts[c - 'a'] -= minn;
			}

			while (minn-- > 0) {
				sb.append(i);
			}
		}

		char[] res = sb.toString().toCharArray();
		Arrays.sort(res);
		return String.valueOf(res);
	}
}
