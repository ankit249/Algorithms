package com.ds.string;

/*
Concept: Controlling set
A Controlling set is a set of letters
CS = { 'l','r','w'}
"hello" --> not controlling because missing r,w
"hello world" --> controlling set because l,r,w covered


Problem: what is the length of shortest controlled substring

Questions
---------
Question? Empty CS ? --> empty set controls everything --> "" is controlled by empty set --> length 0
input dictionary for the input string is lowercase letters + space characters
controlling set is a set and it contains no duplicate
what to return for input string empty


Example
------
Input:  CS =  { 'l','r','w'}  string = "hello world"
Output: substring that represents "worl" - shortest substring which has l,r,w --> so the length is 4

Input: CS = {}, string="uiuiopuiopuo"
Output: 0 --> the substring ""

Input: CS = {} string=""
Output :0

Input: CS = {'l'} string="why"
Output : -1

Bruteforce approace --> generate all substrings and determine if they are controlled by the set, store the length of minimum controlled substring


 */
public class ControllingSet {

    public static void main(String[] args) {

    }
}
