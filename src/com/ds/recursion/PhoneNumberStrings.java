package com.ds.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Given a phone number find all valid business names for that number

Example (from telephone keypad)

ABC   DEF   GHI
 1     2     3

JKL   MNO   PQR
 4     5     6

STU   VWX   YZ
 7     8     9

       -   <- Space or nothing for 0
       0


number: 91   output: ["YA","YB","YC", "ZA", "ZB", "ZC"]


                    9           Y                  Z
                             /  |    \          /  |    \
                    1     A     B     C      A     B     C
                         / \   / \   / \    / \   / \   / \
                    9   Y  Z  Y  Z   Y  Z   Y  Z  Y  Z  Y  Z


TC: 3^n (max)  - if you take 1 1 1 , it will have 27
                 if you take 1 1, it will have 9
                 not all combination has 3, some have 2 so max is 3^n


*/
public class PhoneNumberStrings {
    static char[][] dictionary = {{}, {'A','B','C'}, {'D','E','F'}, {'G','H','I'},
             {'J','K','L'}, {'M','N','O'}, {'P','Q','R'}, {'S','T','U'},
             {'V','W','X'}, {'Y','Z'}};

    private static List<String>  findValidBusinessNames(char[] input) {
        List<String> results = new ArrayList<>();
        char[] slate = new char[input.length];
        helper(input, slate, 0, results);
        return results;
    }

    private static void helper(char[] input, char[] slate, int pos, List<String> results) {
        // base case
        if(pos >= input.length) {
            results.add(new String(slate));
            return;
        }

        // no backtracking needed

        char[] map = dictionary[input[pos] - '0'];
        for(int i = 0; i < map.length; i++) {
            slate[pos] = map[i];
            helper(input, slate, pos + 1, results);
        }
    }

    public static void main(String[] args) {
        int num = 91;
        char[] input = String.valueOf(num).toCharArray();
        List<String> results = findValidBusinessNames(input);
        System.out.println(results);

        // using dictionary map
        /*
        buildDictionary();
        results = findValidBusinessNamesDictionalry(input);
        System.out.println(results);
        */
    }

    /*
    using hashmap as a dictionalry

    static Map<Integer, char[]> dictionaryMap = new HashMap<>();
    public static void buildDictionary() {
        dictionaryMap.put(0, new char[]{});
        dictionaryMap.put(1, new char[]{'A','B','C'});
        dictionaryMap.put(2, new char[]{'D','E','F'});
        dictionaryMap.put(3, new char[]{'G','H','I'});
        dictionaryMap.put(4, new char[]{'J','K','L'});
        dictionaryMap.put(5, new char[]{'M','N','O'});
        dictionaryMap.put(6, new char[]{'P','Q','R'});
        dictionaryMap.put(7, new char[]{'S','T','U'});
        dictionaryMap.put(8, new char[]{'V','W','X'});
        dictionaryMap.put(9, new char[]{'Y','Z'});
    }

    private static List<String>  findValidBusinessNamesDictionalry(char[] input) {
        List<String> results = new ArrayList<>();
        char[] slate = new char[input.length];
        helperD(input, slate, 0, results);
        return results;
    }

    private static void helperD(char[] input, char[] slate, int pos, List<String> results) {
        // base case
        if(pos >= input.length) {
            results.add(new String(slate));
            return;
        }

        // no backtracking needed

        char[] map = dictionaryMap.get(input[pos] - '0');
        for(int i = 0; i < map.length; i++) {
            slate[pos] = map[i];
            helperD(input, slate, pos + 1, results);
        }
    }
    */
}
