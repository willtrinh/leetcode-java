/* 
Implement pow(x, n), which calculates x raised to the power n (i.e. xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
*/
public class Pow_x_n {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        // avoid overflow when n is Integer.MIN_VALUE
        // i.e.: INT_MIN is -2147483648 but INT_MAX is 2147483647 ,so n = -n failed
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        // if negative power, flip it to positive then flip x to 1/x
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
