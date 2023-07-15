/*
💡
2. **Longest Substring Without Repeating Characters**

Given a string `s`, find the length of the **longest substring** without repeating characters.

**Example 1:**
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

*/

package Java_DSA.BasicsOfDSA.Assignment24;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int i = 0, j = 0;

        Set<Character> uniqueChars = new HashSet<>();

        while (i < n && j < n) {
            if (!uniqueChars.contains(s.charAt(j))) {
                uniqueChars.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                uniqueChars.remove(s.charAt(i));
                i++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + length);
    }
}
