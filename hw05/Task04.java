// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
package hw05;

import java.util.Arrays;

public class Task04 { 
    public static void main(String[] args)
    {
        // board length
        int n = 8;        
        char[][] board = new char[n][n];
 
        // init board 2d array with '-' characters
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
 
        System.out.println("I've found next solutions:\n");

        // Start from row 0
        findSolutions(board, 0);
        System.out.printf("All solutions count is %s.\n", counter);
    }

    // Solutions counter
    public static int counter = 0;

    /**
    * Checks all possible threats from previous queens set 
    * @param  board the current chessboard with marked positions of queen set
    * @param  row   the row of queen position
    * @param  col   the column of queen position
    *
    * @return   is position fit or not (boolean)
    */
    public static boolean isFit(char[][] board, int row, int col)
    {
        // checks if queens in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
 
        // checks if queens in the same diagonal 
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
 
        // checks if queens in the same back diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
 
        return true;
    }
 
    /**
    * Prints solution to the console     
    * @param  board the current chessboard with marked positions of queen set
    */
    public static void showSolution(char[][] board)
    {
        System.out.println("   A B C D E F G H ");
        int row = 0;
        for (char[] chars: board) {
            System.out.printf("%d %s\n", row, Arrays.toString(chars).replaceAll(",", ""));
            row++;
        }
        System.out.println();
    }
 
    /**
    * Finds solutions (recursive function)
    * @param  board the current chessboard with marked positions of queen set
    * @param  row   the start row
    *
    * @return   is position fit or not (boolean)
    */
    public static void findSolutions(char[][] board, int row)
    {
        // Show solution if all queens are set
        if (row == board.length) {
            showSolution(board);
            counter++;
            return;
        }
 
        // Try to place queens 
        for (int i = 0; i < board.length; i++)
        {
            // Check if position is fit
            if (isFit(board, row, i)) {
                // place queen on the board
                board[row][i] = 'Q';
 
                // recursive find solutions with next row
                findSolutions(board, row + 1);
 
                // backtrack and remove the queen from board
                board[row][i] = '.';
            }
        }
    }
}
