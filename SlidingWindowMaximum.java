/*
💡 7. **Sliding Window Maximum**

You are given an array of integers `nums`, there is a sliding window of size `k` which is moving from the very left of the array to the very right. You can only see the `k` numbers in the window. Each time the sliding window moves right by one position.

Return *the max sliding window*.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6 7         3
 1 [3  -1  -3] 5  3  6 7         3
 1  3 [-1  -3  5] 3  6 7         5
 1  3  -1 [-3  5  3] 6 7         5
 1  3  -1  -3 [5  3  6]7         6
 1  3  -1  -3  5 [3  6  7]       7
 
 */


package Java_DSA.BasicsOfDSA.Assignment24;
import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;
        for (int i = 0; i < n; i++) {
            // Remove elements from the front of the deque that are outside the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove elements from the back of the deque that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element to the deque
            deque.offer(i);

            // Add the maximum element of the current window to the result array
            if (i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] maxWindow = maxSlidingWindow(nums, k);
        System.out.println("Max sliding window: " + Arrays.toString(maxWindow));
    }
}
