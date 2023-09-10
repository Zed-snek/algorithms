package ed.arrays2d;

public class Matrix {
/*
    Matrix Challenge
Have the function MatrixChallenge(strArr) take the strArr parameter being passed which will be a 2D matrix of 0 and 1's,
and determine the area of the largest rectangular submatrix that contains all 1's. For example: if strArr is
["10100", "10111", "11111", "10010"] then this looks like the following matrix:

    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0

For the input above, you can see the bolded 1's create the largest rectangular submatrix of size 2x3, so your program
should return the area which is 6. You can assume the input will not be empty.

Example 1:
    Input: new String[] {"1011", "0011", "0111", "1111"}
    Output: 8

Example 2:
    Input: new String[] {"101", "111", "001"}
    Output: 3
*/

    private static boolean isThisShape(int x, int y, int startX, int startY, String[] matrix) { //isThisShape(x = 5, y = 1, startX = 0, startY = 0, matrix);

        for (int i = startX; i < startX + x; i++) {
            for (int j = startY; j < startY + y; j++) {
                if (matrix[j].charAt(i) == '0') {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isSuchShape(int x, int y, String[] matrix) {

        for (int i = 0; i <= matrix[0].length() - x; i++) {
            for (int j = 0; j <= matrix.length - y; j++) {
                if (isThisShape(x, y, i, j, matrix)) {
                    return true;
                }
            }
        }

        return false;
    }
    public static void matrix() {
        String[] matrix = {"10100", "10111", "11111", "10010"};
        int max = 0;

        for (int i = 1; i <= matrix[0].length(); i++) {
            for (int j = 1; j <= matrix.length; j++) {
                if (i * j > max) {
                    if (isSuchShape(i, j, matrix)) {
                        max = i * j;
                    }
                }
            }
        }

        System.out.println(max);
    }

}
