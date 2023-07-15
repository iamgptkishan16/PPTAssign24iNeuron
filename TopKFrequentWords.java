/*
💡 6. **Top K Frequent Words**

Given an array of strings `words` and an integer `k`, return *the* `k` *most frequent strings*.

Return the answer **sorted** by **the frequency** from highest to lowest. Sort the words with the same frequency by their **lexicographical order**.

**Example 1:**
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.

*/

package Java_DSA.BasicsOfDSA.Assignment24;

import java.util.*;

public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        // Create a frequency map to count the occurrences of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Create a priority queue to store the words based on their frequencies and lexicographical order
        PriorityQueue<String> pq = new PriorityQueue<>(
                (w1, w2) -> frequencyMap.get(w1).equals(frequencyMap.get(w2)) ? w2.compareTo(w1) :
                        frequencyMap.get(w1) - frequencyMap.get(w2)
        );

        // Iterate through the frequency map and add words to the priority queue
        for (String word : frequencyMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Create a result list to store the k most frequent words
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // Reverse the result list to get the words sorted by the frequency from highest to lowest
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "apple", "banana", "apple"};
        int k = 2;

        List<String> topKFrequentWords = topKFrequent(words, k);
        System.out.println("The " + k + " most frequent words are: " + topKFrequentWords);
    }
}
