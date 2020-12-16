/* 
Given a string s, find the length of the longest substring without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0

*/
public class LongestSubstringWithoutRepeatingCharacters {
    // Using Set, Time: O(2n) = O(n), Space: O(min(m,n))
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null)
            return 0;
        int len = s.length();
        // sliding window pointers, to keep track of the longest substring as we expand
        // the window pointers
        int i = 0, j = 0;
        // length of longest substring.
        int res = 0;
        // HashSet to keep track of unique characters in the string
        Set<Character> set = new HashSet<>();

        while (i < len && j < len) {
            // if set doesn't contain the character, add to the set and increment the
            // pointer
            // also compare current res value with the size of the window
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            }
            // else if set already contains the character, remove the character from set
            else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    // Using Map, Time: O(n), Space: O(min(m,n))
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
