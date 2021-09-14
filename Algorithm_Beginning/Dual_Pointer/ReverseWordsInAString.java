/*
Description
	Given a string `s`, reverse the order of characters in each word within a sentense while still preserving whitespace and initial word order.
 */

class Solution {
	public String reverseWords(String s) {
		StringBuffer ret = new StringBuffer();
		int len = s.length();
		int i = 0, left;
		while (i < len) {
			left = i;
			while (i < len && s.charAt(i) != ' ')
				i++;
			for (int right = i; right >= left; right--)
				ret.append(s.charAt(i));
			while (i < len && s.charAt(i) == ' ') {
				i++;
				ret.append(' ');
			}
		}
		return ret.toString();
	}
}
