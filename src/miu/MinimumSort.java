package miu;

/*
The recursive strategy for MinSort is: Given an input String s consisting only of characters a-z do the following:
1. Find the position minpos of the alphabetically least character in s
2. Swap the character in position 0 with the character ch in position minpos
3. Remove character ch from the string, store it, and call the remaining String t
4. Sort t and place in storage to the right of the character ch
5. Return the stored String.
*/

public class MinimumSort {

	public static void main(String[] args) {
		MinimumSort ms = new MinimumSort();
		String result = ms.sort("wazibe");
		System.out.println(result);

	}

	public Character rmin(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char ch = str.charAt(0);
		if (str.length() == 1)
			return ch;
		char c = rmin(str.substring(1));
		return (ch < c ? ch : c);
	}

	public String sort(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		if (str.length() == 1)
			return str;
		char ch = rmin(str);
		int minpos = str.indexOf(ch);
		char start = str.charAt(0);
		String s2 = "";
		for (int i = 1; i < str.length(); i++) {
			if (i == minpos) {
				s2 = s2 + start;
			} else {
				s2 = s2 + str.charAt(i);
			}
		}
		String t = str.charAt(minpos) + sort(s2);
		return t;

	}

}
