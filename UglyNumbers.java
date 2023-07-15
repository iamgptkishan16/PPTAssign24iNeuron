/*
💡 5. **Ugly Numbers**

An **ugly number** is a positive integer whose prime factors are limited to `2`, `3`, and `5`.

Given an integer `n`, return *the* `nth` ***ugly number***.

**Example 1:**
Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

*/

package Java_DSA.BasicsOfDSA.Assignment24;

public class UglyNumbers {
    public static int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int nextMultipleOf2 = 2, nextMultipleOf3 = 3, nextMultipleOf5 = 5;

        for (int i = 1; i < n; i++) {
            int nextUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            uglyNumbers[i] = nextUglyNumber;

            if (nextUglyNumber == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = uglyNumbers[i2] * 2;
            }

            if (nextUglyNumber == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = uglyNumbers[i3] * 3;
            }

            if (nextUglyNumber == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = uglyNumbers[i5] * 5;
            }
        }

        return uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        int nthUgly = nthUglyNumber(n);
        System.out.println("The " + n + "th ugly number is: " + nthUgly);
    }
}
