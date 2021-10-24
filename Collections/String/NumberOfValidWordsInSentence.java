class Solution {
	public int countValidWords(String sentence) {
		int length = sentence.length();
		int ans = 0;
		char tmp;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			tmp = sentence.charAt(i);
			if (tmp != ' ') {
				sb.append(tmp);
			}
			if (tmp == ' ' || i == length - 1) {
				if (isValidWord(sb.toString())) {
					ans++;
				}
				sb = new StringBuilder();
			}
		}

		return ans;
	}

	private boolean isValidWord(String word) {
		if (word == null || word == "" || word.length() == 0) {
			return false;
		}
		int length = word.length();
        if (word.charAt(0) == '-') {
            return false;
        }
		if ((word.charAt(0) < 'a' || word.charAt(0) > 'z') && length != 1) {
			return false;
		}

		char tmp;
		int count = 0;

		for (int i = 0; i < length; i++) {
			tmp = word.charAt(i);
			if (tmp >= '0' && tmp <= '9') {
				return false;
			}
			if (tmp < 'a' || tmp > 'z') {
				if (tmp == '-') {
					if (i == length - 1 || (i < length - 1 && (word.charAt(i + 1) < 'a' || word.charAt(i + 1) > 'z'))) {
						return false;
					}
					count++;
					if (count > 1) {
						return false;
					}
				} else {
					if (i != length - 1) {
						return false;
					}
				}
			}
		}

		return true;
    }
}
