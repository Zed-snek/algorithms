package ed.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntervalListIntersection {

/*
https://leetcode.com/problems/interval-list-intersections/description/

You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi]
and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed
interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

Example 1:
    Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
    Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

Example 2:
    Input: firstList = [[1,3],[5,9]], secondList = []
    Output: []
*/


    private int[] interSectionPair(int[] a, int[] b) {
        if (a[1] < b[0] || b[1] < a[0])
            return null;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a[0], a[1], b[0], b[1]));
        Collections.sort(list);
        return new int[]{list.get(1), list.get(2)};
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        if (firstList.length * secondList.length == 0)
            return new int[0][0];
        int[] x;
        List<int[]> list = new ArrayList<>();
        for (int[] ints : firstList) {
            for (int[] value : secondList) {
                x = interSectionPair(ints, value);
                if (x != null)
                    list.add(x);
            }
        }

        int size = list.size();
        int[][] result = new int[size][2];
        for (int i = 0; i < size; i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }

        return result;
    }

}
