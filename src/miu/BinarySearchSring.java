package miu;

/*
Given a String s in which characters occur in ascending order, and given a character c, it returns true if c occurs in s, false otherwise.
Implement the following strategy: Given String s and char c: Let len denote the length of s.
 - Let m = len /2 and let ch be the character at position m in s.
 - If ch == c, return true
 - Else if c < ch, return true if c is in the left half of s, false otherwise
 - Else if c > ch, return true if c is in the right half of s, false otherwise
*/

public class BinarySearchSring {

	public static void main(String[] args) {
		boolean result = search("abcdefg", 'd');
		System.out.println("Is 'd' in 'abcdefg'? " + result);
		boolean result2 = search("abcdefg", 'x');
		System.out.println("Is 'x' in  'abcdefg'? " + result2);

	}

	static boolean search(String str, char c) {
		if (str == null || str.length() == 0)
			return false;

		int mid = str.length() / 2;
		char ch = str.charAt(mid);
		if (ch == c)
			return true;
		if (ch < c) {
			return search(str.substring(mid + 1), c);

		} else {
			return search(str.substring(0, mid), c);
		}
	}

}
