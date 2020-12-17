/* 
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
Both strings consists only of lowercase characters.

*/
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        // empty s string is subsequence of string t
        if (s.length() == 0)
            return true;
        int indexS = 0, indexT = 0;
        // traverse through string t, since string s is subsequence of t and therefore
        // has smaller length
        while (indexT < t.length()) {
            // if char in s at indexS == char in t at indexT then
            // move pointer indexS forward
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                // last index of string s and char in s at indexS == char in t at indexT then
                // s is subsequence of t, return true
                if (indexS == s.length())
                    return true;
            }
            // if not equal, move indexT forward.
            indexT++;
        }
        return false;
    }
}
