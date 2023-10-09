package ed.arrays;

import java.util.Arrays;
import java.util.Map;
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

        int[][] result = new int[2][k];

        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        int min;
        int minId;
        for (int key : map.keySet()) {
            int value = Math.toIntExact(map.get(key));
            min = result[1][0];
            minId = 0;
            for (int i = 0; i < k; i++) {
                if (result[1][i] < min) {
                    min = result[1][i];
                    minId = i;
                }
            }
            if (min < value) {
                result[0][minId] = key;
                result[1][minId] = value;
            }
        }
        return result[0];
    }
}
