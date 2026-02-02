// Assignment 2 which was given for practice in class

// questions are

/*
Strings and String Builder

1) Reverse a String
Constraint: Don’t use StringBuilder.reverse()
Input: "hello"
Output: "olleh"

2) Check Palindrome
Input: "madam"
Output: true

3) Find First Non-Repeating Character
Input: "aabbcdde"
Output: c

4) Reverse Words in a Sentence
Input: "Java is awesome"
Output: "awesome is Java"*/

// codes are as follow

public class Main {

    // 1) Reverse a String
    static String reverseString(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    // 2) Check Palindrome
    static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }

    // 3) First Non-Repeating Character
    static char firstNonRepeating(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return c;
            }
        }
        return '?';
    }

    // 4) Reverse Words in Sentence
    static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";

        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i];
            if (i != 0) result += " ";
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(reverseString("hello"));
        System.out.println(isPalindrome("madam"));
        System.out.println(firstNonRepeating("aabbcdde"));
        System.out.println(reverseWords("Java is awesome"));
    }
}
