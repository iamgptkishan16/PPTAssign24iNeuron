/*
 
💡 8. **Find K Closest Elements**

Given a **sorted** integer array `arr`, two integers `k` and `x`, return the `k` closest integers to `x` in the array. The result should also be sorted in ascending order.

An integer `a` is closer to `x` than an integer `b` if:

- `|a - x| < |b - x|`, or
- `|a - x| == |b - x|` and `a < b`

**Example 1:**

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]


*/

package Java_DSA.BasicsOfDSA.Assignment24;

import java.util.*;

public class KClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k) {
            int mid = left + (right - left) / 2;

            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;

        List<Integer> closestElements = findClosestElements(arr, k, x);
        System.out.println("Closest elements: " + closestElements);
    }
}
