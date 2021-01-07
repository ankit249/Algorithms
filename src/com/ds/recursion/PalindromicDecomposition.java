package com.ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
Palindromic Decomposition Of A String

Find all palindromic decompositions of a given string s.
A palindromic decomposition of string is a decomposition of the string into substrings, such that all those substrings are valid palindromes.
Example
Input: "abracadabra"
Output: [ "a|b|r|a|c|a|d|a|b|r|a", "a|b|r|a|c|ada|b|r|a", "a|b|r|aca|d|a|b|r|a" ]

Notes
Input Parameters: There is only one argument: string s.
Output: Return array of string res, containing ALL possible palindromic decompositions of given string. To separate substrings in the decomposed string, use '|' as a separator between them.
You need not to worry about the order of strings in your output array. Like for s = "aa", arrays ["a|a", "aa"] and ["aa", "a|a"] both will be accepted.
In any string in your returned array res, order of characters should remain the same as in the given string. (i.e. for s = "ab" you should return ["a|b"] and not ["b|a"].)
Any string in the returned array should not contain any spaces. e.g. s = "ab" then ["a|b"] is expected, ["a |b"] or ["a| b"] or ["a | b"] will give the wrong answer.


Constraints:
1 <= |s| <= 20
s only contains lowercase letters ('a' - 'z').


Any string is its own substring.
Custom Input
Input Format: The first and only line of input should contain a string s, denoting the input string. If s = “abracadabra”, then input should be: abracadabra
Output Format: Let’s denote size of res array as m, where res is the resultant array of string returned by solution function.

Then, there will be m lines of output, where ith line contains a string res[i], denoting string at index i of res.
For input s = “abracadabra”, output will be:

a|b|r|a|c|ada|b|r|a
a|b|r|aca|d|a|b|r|a
a|b|r|a|c|a|d|a|b|r|a

 */
public class PalindromicDecomposition {


    static String[] generate_palindromic_decompositions(String s) {
        List<String> results = new ArrayList<>();
        char[] slate = new char[2 * s.length()];
        helper(s.toCharArray(), 0, slate, 0, results);
        return results.toArray(new String[results.size()]);
    }
    static void helper(char[] input, int pos, char[] slate, int curr, List<String> results) {
        if (pos >= input.length) {
            results.add(new String(slate, 0, curr - 1));
            return;
        }
        for (int i = pos; i < input.length; i++) {
            int lengthOfCharAdded = i - pos;
            slate[curr + lengthOfCharAdded] = input[i];
            if (isPalindrome(input, pos, i)) {
                slate[curr + (i - pos) + 1] = '|';
                helper(input, pos + lengthOfCharAdded + 1, slate, curr + lengthOfCharAdded + 2 /* 1 for | and 1 for next char*/, results);
            }
        }
    }

    static boolean isPalindrome(char[] a, int lo, int hi) {
        while (lo < hi) {
            if (a[lo] == a[hi]) {
                lo++;
                hi--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "abaca";
        String[] result = generate_palindromic_decompositions(input);
        System.out.println(Arrays.toString(result));
    }



}
