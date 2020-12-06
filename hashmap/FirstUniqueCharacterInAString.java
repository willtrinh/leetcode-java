/* 
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.

*/
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = map.get(c);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
