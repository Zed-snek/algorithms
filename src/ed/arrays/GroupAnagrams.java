package ed.arrays;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

    Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    Example 2:
Input: strs = [""]
Output: [[""]]

    Example 3:
Input: strs = ["a"]
Output: [["a"]]*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        Arrays.stream(strs)
                .forEach(s -> {
                    var s2 = new StringBuilder();
                    s.chars().sorted().forEach(code -> s2.append((char)code));
                    String sorted = s2.toString();

                    if (map.containsKey(sorted))
                        map.get(sorted).add(s);
                    else
                        map.put(sorted, new ArrayList<>(List.of(s)));
                });
        return new ArrayList<>(map.values());
    }
}
