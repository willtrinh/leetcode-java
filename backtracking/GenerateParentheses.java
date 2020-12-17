/* 
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            res.add(current);
            return;
        }

        if (open < max) {
            backtrack(res, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(res, current + ")", open, close + 1, max);
        }
    }
}
