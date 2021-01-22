package com.ds.graphnode;

import java.util.*;

/*
Find Order Of Characters From Alien Dictionary
Given a sorted dictionary of an alien language, find the order of characters in the alphabet.
Example One
Input: ["baa", "abcd", "abca", "cab", "cad"]
Output: "bdac"



Example Two

Input: words = ["caa", "aaa", "aab"]
Output: "cab"

Notes
Input Parameters: Function has one argument, array of strings, the dictionary sorted in the lexicographical order of the alien language.
Output: Return a string consisting of all the characters of the alien alphabet, in order.

Constraints:

1 <= characters in all the words in the dictionary <= 10^5
Input will consist of lowercase latin characters only.
Input will be such that it is possible to determine the alphabet order uniquely.
The dictionary may contain duplicate words.


Custom Input
Input Format: The first line of input should contain an integer n, denoting size of input array words. In next n lines, i-th line should contain a string words[i], denoting a value at index i of words.
If n = 5 and words = ["baa", "abcd", "abca", "cab", "cad"], then input should be:
5
baa
abcd
abca
cab
cad

Output Format: There will be only one line of output, containing a string ordered, denoting the result returned by solution function. For input n = 5 and words = ["baa", "abcd", "abca", "cab", "cad"], output will be:
bdac


TC: extracting edges - > ( 2 * Total number of characters + Unique Characters + Total number of words) which is equal to O(Total number of characters)
for TOPO sort O(N+E) - node is character
                       Edges is word

                       so O(C + W)

SC:  so O(C + W)

 */

public class FindOrderOfCharactersFromAlienDictionaryTopoSort {


    // representation of the graph in adjacency lists
    private static Map<Character, List<Character>> neighbors = new HashMap<>();

    public static void addEdge(Character from, Character to) {
        if (neighbors.get(from) == null) {
            neighbors.put(from, new ArrayList<Character>());
        }
        if (neighbors.get(to) == null) {
            neighbors.put(to, new ArrayList<Character>());
        }

        neighbors.get(from).add(to);
    }

    // you need to find the inDegree and store it in the map for all the nodes, needed for topological sort
    public static Map<Character, Integer> inDegree() {
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        for (Character v : neighbors.keySet()) {
            result.put(v, 0);
        }

        for (Character from : neighbors.keySet()) {
            for (Character to : neighbors.get(from)) {
                result.put(to, result.get(to) + 1);
            }
        }

        return result;
    }

    // topological sort
    public static String topSort() {
        Map<Character, Integer> in_deg = inDegree();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for (Character v : neighbors.keySet()) {
            if (in_deg.get(v) == 0) {
                stack.push(v);
            }
        }

        while (!stack.isEmpty()) {
            Character element = stack.pop();
            sb.append(element);
            for (Character v : neighbors.get(element)) {
                in_deg.put(v, in_deg.get(v) - 1);
                if (in_deg.get(v) == 0) {
                    stack.push(v);
                }
            }
        }

        // this condition means no cycle
        if (sb.toString().length() != neighbors.size()) {
            return null;
        }

        return sb.toString();
    }


    // This function fidns and prints order
    // of characer from a sorted array of words.
    // alpha is number of possible alphabets
    // starting from 'a'. For simplicity, this
    // function is written in a way that only
    // first 'alpha' characters can be there
    // in words array. For example if alpha
    //  is 7, then words[] should contain words
    // having only 'a', 'b','c' 'd', 'e', 'f', 'g'
    private static String find_order(String[] words) {

        // edge case - if there are repeating one character letters
        String first = words[0];
        boolean flag = false;
        for(String string : words) {
            if(first.equalsIgnoreCase(string)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if(flag) return String.valueOf(first.charAt(0));


        for (int i = 0; i < words.length - 1; i++) {
            // Take the current two words and find the first mismatching
            // character
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                // If we find a mismatching character, then add an edge
                // from character of word1 to that of word2
                if (word1.charAt(j) != word2.charAt(j)) {
                    addEdge(word1.charAt(j), word2.charAt(j));
                    break;
                }
            }
        }

        // Print topological sort of the above created graph
        return topSort();

    }


    // Driver program to test above functions
    public static void main(String[] args) {
        String[] words = {"caa", "aaa", "aab"};
        System.out.println(find_order(words));

        neighbors = new HashMap<>();
        String[] words1 = {"aaa"};
        System.out.println(find_order(words1));

        neighbors = new HashMap<>();
        String[] words2 = {"aaa", "aaa"};
        System.out.println(find_order(words2));

        neighbors = new HashMap<>();
        String[] words3 = {"g", "g", "g", "g"};
        System.out.println(find_order(words3));
    }


}



