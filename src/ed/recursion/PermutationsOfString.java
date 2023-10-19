package ed.recursion;

/*Print all permutations of string.
AB = AB, BA

*/


public class PermutationsOfString {

    public static void showAllPermutationsOfString(String prefix, String s) {
        if (s.length() == 1) {
            System.out.println(prefix + s);
        }
        else {
            for (int i = 0; i < s.length(); i++) {
                showAllPermutationsOfString(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
            }
        }
    }

    public static void main(String[] args) {
        showAllPermutationsOfString("", "ABCD");
    }

}
