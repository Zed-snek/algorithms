package ed.string;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {

/*
    https://leetcode.com/problems/integer-to-roman/

    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply
X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same
principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given an integer, convert it to a roman numeral.

    Example 1:
        Input: num = 3
        Output: "III"
        Explanation: 3 is represented as 3 ones.
*/

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        Map<Integer, String> map = new TreeMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        LinkedList<Integer> linked = new LinkedList<>(map.keySet());

        int biggest;
        while (num != 0) {
            biggest = linked.pollLast();
            while (num >= biggest) {
                num -= biggest;
                roman.append(map.get(biggest));
            }
        }

        return roman.toString();
    }

}
