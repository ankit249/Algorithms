package com.ds.recursion;

import java.util.ArrayList;
import java.util.List;


// IN JAVA USE CHARACTER ARRAY where you can

/*

Recursion Fundamental

(1) Check if I can backtrack
(2) Check for basecase
(3) modify shared state
(4) recursive call
(5) unmodify shared state


                                slate ""
                   "a"                            "A"
                   "a1"                           "A1"
                   "a12"                          "A12"
              "a12b"   "a12B"               "A12b"     "A12B"
              "a12b3"  "a12B3"              "A12b3"    "A12B3"


TC: O(2^k) where k are number of characters in the string with length n

 */

public class LetterCasePermuation {

    private static List<String> letterCasePermuation(char[] input) {
        var result = new ArrayList<String>();
        helper(input, new char[input.length], 0, result);
        return result;
    }

    private static void helper(char[] input, char[] slate, int pos, List<String> result) {
        // no backtracking needed

        // base case
        if(pos >= input.length) {
            result.add(new String(slate));
            return;
        }

        // recursion call
        if(Character.isLetter(input[pos])) {  // checks both uppercase or lowercase
            slate[pos] = Character.toLowerCase(input[pos]);
            helper(input, slate, pos + 1, result);
            slate[pos] = Character.toUpperCase(input[pos]);
            helper(input, slate, pos + 1, result);
        } else {
            slate[pos] = input[pos];
            helper(input, slate, pos + 1, result);
        }
    }

    public static void main(String[] args) {
        String input = "a12b3";
        List<String> results = letterCasePermuation(input.toCharArray());
        System.out.println(results);
    }
}
