package com.ds.string;

// This is similar to All Palindromes or All Palindrome Substrings. (since its contiguous)
// here just find maximum length of palindrome

/*

Perhaps you could iterate across potential middle character (odd length palindromes) and middle points between characters (even length palindromes) 
and extend each until you cannot get any further (next left and right characters don't match).
That would save a lot of computation when there are no many palidromes in the string. 
In such case the cost would be O(n) for sparse palidrome strings.

For palindrome dense inputs it would be O(n^2) as each position cannot be extended more than the length of the array / 2. 
Obviously this is even less towards the ends of the array. 

Time Complexity O(n), Space Complexity O(1)

*/
public class LongestPalindromeSubstring {

	public static String longestPalindromeSubstring(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}

		String longest = "";

		for (int i = 0; i < input.length(); i++) {
			// for even length palindrome
			String tmpPalindrome = helper(input, i, i + 1);
			if (tmpPalindrome.length() > longest.length()) {
				longest = tmpPalindrome;
			}

			// for odd length palindrome
			tmpPalindrome = helper(input, i, i);
			if (tmpPalindrome.length() > longest.length()) {
				longest = tmpPalindrome;
			}

			if (longest.length() == input.length()) {
				return longest;
			}
		}

		return longest;
	}

	private static String helper(String input, int lo, int hi) {
		String result = "";
		while (lo >= 0 && hi < input.length() && input.charAt(lo) == input.charAt(hi)) {
			result = input.substring(lo, hi + 1);
			lo--;
			hi++;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubstring("aaba"));
		System.out.println(longestPalindromeSubstring("ccc"));
		System.out.println(longestPalindromeSubstring("a"));
	}
}
