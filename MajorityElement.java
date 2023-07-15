/* 
💡 3. **Majority Element**

Given an array `nums` of size `n`, return *the majority element*.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

**Example 1:**
Input: nums = [3,2,3]
Output: 3

*/

package Java_DSA.BasicsOfDSA.Assignment24;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int majorityElement = 0;
        int majorityCount = 0;

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);

            if (count > majorityCount) {
                majorityElement = num;
                majorityCount = count;
            }
        }

        return majorityElement;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int majority = majorityElement(nums);
        System.out.println("The majority element is: " + majority);
    }
}
