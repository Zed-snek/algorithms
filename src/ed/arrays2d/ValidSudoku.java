package ed.arrays2d;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

/*
https://leetcode.com/problems/valid-sudoku/

    Determine if a 9 x 9 Sudoku board is valid.
Only the filled cells need to be validated according to the following rules:

1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    Note:
- A Sudoku board (partially filled) could be valid but is not necessarily solvable.
- Only the filled cells need to be validated according to the mentioned rules.

    Example 1:
Input: board =
    [["5","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]
Output: true

*/


    private boolean checkWithSet(char[] line) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (line[i] != '.' && !set.add(line[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {

        char[] column;
        for (int i = 0; i < 9; i++) {

            if (checkWithSet(board[i]))
                return false;

            column = new char[9];
            for (int j = 0; j < 9; j++) {
                column[j] = board[j][i];
            }
            if (checkWithSet(column))
                return false;
        }

        int rowStart = 0;
        int colStart = 0;
        int rowBlock = -1;
        int colBlock = 0;
        int it;
        for (int i = 0; i < 9; i++) {
            column = new char[9];
            it = 0;
            if ((i + 1) % 3 == 1)
                rowBlock++;
            rowStart = rowBlock * 3;

            for (int row = rowStart; row < rowStart + 3; row++) {
                for (int col = colStart; col < colStart + 3; col++) {
                    column[it] = board[row][col];
                    it++;
                }
            }

            if (checkWithSet(column))
                return false;

            colBlock = colBlock < 2 ? colBlock + 1 : 0;
            colStart = colBlock * 3;
        }

        return true;
    }

}
