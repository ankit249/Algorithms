package com.ds.string;

/*

Have the function LetterChanges(str) take the str parameter being passed and 
modify it using the following algorithm. Replace every letter in the string with 
the letter following it in the alphabet (ie. c becomes d, z becomes a). 
Then capitalize every vowel in this new string (a, e, i, o, u) and finally return 
this modified string. 

*/
class LetterChanges {

	public static String letterChanges(String str) {
		if (str == null)
			return null;

		char[] ch = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(ch[i])) {
				if (ch[i] == 'z') {
					ch[i] = 'A';
					continue;
				}

				ch[i] = (char) (ch[i] + 1); // next letter
				if ("aeiou".indexOf(ch[i]) != -1) {
					ch[i] = (char) (ch[i] - 32); // convert lower case to upper case
				}
			}
		}

		return String.valueOf(ch);
	}

	public static void main(String[] args) {
		// keep this function call here
		System.out.print(letterChanges("helloworld"));
	}
}
