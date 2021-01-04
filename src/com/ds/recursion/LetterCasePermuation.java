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

 */

public class LetterCasePermuation {

    private static List<String> letterCasePermuation(String input) {
        var result = new ArrayList<String>();
        helper(input.toCharArray(), 0, new char[input.length()], result);
        return result;
    }

    private static void helper(char[] input, int pos, char[] slate, List<String> result) {
        // no backtracking needed

        // base case
        if(pos >= input.length) {
            result.add(new String(slate));
            return;
        }

        // recursion call
        if(Character.isLetter(input[pos])) {  // checks both uppercase or lowercase
            slate[pos] = Character.toLowerCase(input[pos]);
            helper(input, pos + 1, slate, result);
            slate[pos] = Character.toUpperCase(input[pos]);
            helper(input, pos + 1, slate, result);
        } else {
            slate[pos] = input[pos];
            helper(input, pos + 1, slate, result);
        }
    }

    public static void main(String[] args) {
        String input = "a12b3";
        List<String> results = letterCasePermuation(input);
        System.out.println(results);
    }
}
