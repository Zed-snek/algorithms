package ed.string;

/*
Valid Palindrome
https://leetcode.com/problems/valid-palindrome/description/

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

    Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

    Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

    Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

*/

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        var x = s.chars()
                .map(n -> n >= 65 && n <= 90 ? n + 32 : n)
                .filter(n -> n >= 48 && n <= 57 || n >= 97 && n <= 122)
                .toArray();

        int left = 0, right = x.length - 1;
        while (left < right) {
            if (x[left] != x[right])
                return false;
            left++;
            right--;
        }

        return true;
    }


}
