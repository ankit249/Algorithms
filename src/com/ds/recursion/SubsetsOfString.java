package com.ds.recursion;

/*


Generate All Subsets Of A Set

Generate ALL possible subsets of a given set. The set is given in the form of a string s containing distinct lowercase characters 'a' - 'z'.
Example

Input: "xy"
Output: ["", "x", "y", "xy"]



Notes

Input Parameters: There is only one argument denoting string s.
Output: Return array of strings res, containing ALL possible subsets of given string. You need not to worry about order of strings in your output array. E.g. s = "a", arrays ["", "a"] and ["a", ""]  both will be accepted.
Order of characters in any subset must be same as in the input string. For s = "xy", array ["", "x", "y", "xy"] will be accepted, but ["", "x", "y", "yx"] will not be accepted.

Constraints:

0 <= |s| <= 20
s only contains distinct lowercase alphabetical letters ('a' - 'z').
Empty set is a subset of any set.

Any set is a subset of itself.

Custom Input
Input Format: The first and only line of input should contain a string s, denoting the input string.
If s = “xy”, then input should be: xy
Output Format: Let’s denote the size of res as m, where res is the resultant array of strings returned by the solution function.
Then, there will be m lines of output, where ith line contains string at index i of res.

For input s = “xy”, output will be:

----------- START of output -----------

4
x
y

xy

----------- END of output ---------------

(Note that the first line of the output is the number strings in the returned array. The next line is an empty line, corresponding to empty set [“”].)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsOfString {
    public static List<String> getSubsets(String input) {
        var results = new ArrayList<String>();
        helper(input, 0, new char[input.length()], 0, results);
        return results;
    }

    private static void helper(String input, int pos, char[] slate, int slateSize, List<String> results) {
        // (1) basecase
        if(pos >= input.length()) {
            results.add(slateSize == 0? new String("") : new String(slate, 0, slateSize));
            return;
        }

        // (2) recursion
        helper(input, pos + 1, slate, slateSize, results);
        slate[slateSize] = input.charAt(pos);
        helper(input, pos + 1, slate, slateSize + 1, results);
    }

    public static void main(String[] args) {

        String input = "xy";
        List<String> result = getSubsets(input);
        System.out.println(result);
    }

}
