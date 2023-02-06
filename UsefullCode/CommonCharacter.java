package UsefullCode;
/******************************************************************************
 * This code implements a solution to find common characters in multiple
 * strings. It is intended for beginners who are looking for a basic
 * understanding of the logic, and may not be the most efficient in terms of
 * runtime. Advanced users who require faster performance can use more optimized
 * methods available online.
 *******************************************************************************/

import java.util.Arrays;
public class CommonCharacters {
	// Main Method
	public static void main(String[] args) {
		String result = findString(new String[] { "Hello-World", "Mrx-Noobie", "Life-Of-Money" });
		System.out.println("1: "+result);
		
		result = findString(new String[] { "result", "public static", "console", "comments"});
		System.out.println("2: " + result);
		
		result = findString(new String[] { "ABCDE", "XYZA", "YCDK", "WWW.HELLOWORLD.COM"});
		System.out.println("3: " + result);
		/**************
		 * Console
		 * 1: -eo
		 * 2: s
		 * 3: NONE!
		 *************/
	}
	public static String findString(String[] str) {
		String findedString = "";
		// loop through the string array
		for (int i = 0; i < str.length; i++) {
			// convert each string into a character array
			char charArray[] = str[i].toCharArray(); // 1
			// sort the character array in ascending order
			Arrays.sort(charArray); // 2
			// convert the sorted character array back to a string
			str[i] = new String(charArray); // 3
		}

		// loop through the first string in the string array
		for (int i = 0; i < str[0].length(); i++) {
			int temp = 0;
			// loop through the next strings in the string array
			for (int j = 1; j < str.length; j++) {
				// loop through the characters in the current string
				for (int k = 0; k < str[j].length(); k++) {
					// check if the current character in str[0] is in str[j]
					if (str[0].charAt(i) == (str[j].charAt(k))) {
						// split the string str[j] into two parts: before and after the current
						// character
						String firstPart = str[j].substring(0, str[j].indexOf(str[j].charAt(k)));
						String lastPart = str[j].substring(str[j].indexOf(str[j].charAt(k)) + 1);
						// combine the two parts to remove the current character from str[j]
						str[j] = firstPart + lastPart;
						temp++;
						break;
					}
				}
			}
			// if the current character is in all strings, add it to the findedString
			if (temp == str.length - 1) {
				findedString = findedString + str[0].charAt(i);
			}
		}
		// if findedString is still empty, set it to "NONE!"
		if (findedString.equals("")) {
			findedString = "NONE!";
		}
		return findedString;
	}

}
