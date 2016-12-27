package com.ds.string;

import java.util.HashSet;
import java.util.Set;

// This is All Palindromes or All Palindrome Substrings. (since its contiguous)

/*
 
Perhaps you could iterate across potential middle character (odd length palindromes) and middle points between characters (even length palindromes) 
and extend each until you cannot get any further (next left and right characters don't match).
That would save a lot of computation when there are no many palidromes in the string. 
In such case the cost would be O(n) for sparse palidrome strings.

For palindrome dense inputs it would be O(n^2) as each position cannot be extended more than the length of the array / 2. 
Obviously this is even less towards the ends of the array. 

Time Complexity O(n), Space Complexity O(1)

*/

public class PrintAllPalindromes {

	 public static Set<String> palindromes(final String input) {

		final Set<String> result = new HashSet<String>();

	     for (int i = 0; i < input.length(); i++) {
	         // expanding even length palindromes:
			expandPalindromes(result, input, i, i + 1);

	         // expanding odd length palindromes:
			expandPalindromes(result, input, i, i);
	     } 
	     return result;
	  }

	public static void expandPalindromes(final Set<String> result, final String input, int lo, int hi) {
		while (lo >= 0 && hi < input.length() && input.charAt(lo) == input.charAt(hi)) {
			result.add(input.substring(lo, hi + 1));
			lo--;
			hi++;
	      }
	  }


	public static void main(String[] args) {
		Set<String> set = palindromes("abab");
		System.out.println(set);

	}
}
