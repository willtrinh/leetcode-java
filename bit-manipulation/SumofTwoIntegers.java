/* 
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = -2, b = 3
Output: 1
*/
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        // a will be the running addition result
        // b will hold the carries
        while (b != 0) {
            // use 'and' operator to find the carry

            int carry = a & b;
            // use 'xor' (exclusive or) operator to simulate addition within the iteration
            // addition result will be stored in a
            a = a ^ b;
            // use 'left shift' operator to hold the left-shifted carry
            b = carry << 1;
        }

        return a;
    }
}
