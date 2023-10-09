package ed.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/* https://leetcode.com/problems/top-k-frequent-elements

Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

    Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

    Example 2:
Input: nums = [1], k = 1
Output: [1]
*/


public class topKFrequent {

    public int[] solution(int[] nums, int k) {
        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        TreeMap<Integer, Long> tree = new TreeMap<>((k1, k2) -> {
            int compare = Long.compare(map.get(k2), map.get(k1));
            if (compare == 0)
                return k1.compareTo(k2);
            return compare;
        });
        tree.putAll(map);

        int[] result = new int[k];
        int it = 0;
        var iterator = tree.keySet().iterator();
        while (iterator.hasNext() && it < k) {
            result[it] = iterator.next();
            it++;
        }
        return result;
    }
}
