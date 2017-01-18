package com.ds.string;

/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") return false
isMatch("aa","aa") return true
isMatch("aaa","aa") return false
isMatch("aa", "a*") return true
isMatch("aa", ".*") return true
isMatch("ab", ".*") return true
isMatch("aab", "c*a*b") return true

 */
public class RegularExpression {

	public static boolean isMatch(String s, String p) {
		// base case
		if (p.length() == 0) {
			return s.length() == 0;
		}

		// special case
		if (p.length() == 1) {

			// if the length of s is 0, return false
			if (s.length() == 0) {
				return false;
			}

			// if the first does not match, return false
			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			}

			// otherwise, compare the rest of the string of s and p.
			else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}

		// case 1: when the second char of p is not '*'
		if (p.charAt(1) != '*') {
			if (s.length() == 0) {
				return false;
			}
			if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}

		// case 2: when the second char of p is '*', complex case.
		else {
			// case 2.1: a char & '*' can stand for 0 element
			if (isMatch(s, p.substring(2))) {
				return true;
			}

			// case 2.2: a char & '*' can stand for 1 or more preceding element,
			// so try every sub string
			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a"));      // return false
		System.out.println(isMatch("aa", "aa"));     // return true
		System.out.println(isMatch("aaa", "aa"));    // return false
		System.out.println(isMatch("aa", "a*"));     // return true
		System.out.println(isMatch("aa", ".*"));     // return true
		System.out.println(isMatch("ab", ".*"));     // return true
		System.out.println(isMatch("aab", "c*a*b")); // return true
		System.out.println(isMatch("", "a*"));       // return true
	}
}
