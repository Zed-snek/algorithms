package ed.arrays;

import java.util.TreeSet;

/* https://leetcode.com/problems/longest-consecutive-sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

    Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        var set = new TreeSet<Integer>();
        for (int num : nums)
            set.add(num);

        int max = 1;
        int streak = 1;
        for (var num : set) {
            if (set.contains(num + 1))
                streak++;
            else {
                if (streak > max)
                    max = streak;
                streak = 1;
            }
        }
        if (streak > max)
            max = streak;

        return max;
    }

}
