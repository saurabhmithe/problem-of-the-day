package Sep_18;

public class KnightsTour {

    /*

    A knight's tour is a sequence of moves by a knight on a chessboard such that all squares are visited once.
    Given N, write a function to return the number of knight's tours on an N by N chessboard.

    */

    int n = 8;

    public static void main(String[] args) {
        KnightsTour knightsTour = new KnightsTour();
        boolean isPresent = knightsTour.find();
        System.out.println(isPresent);
    }

    public boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < n && y >= 0 && y < n && sol[x][y] == -1);
    }

    /**
     * Time Complexity - O(k^n) where k is a constant and n is the number of squares on the chess board
     * Space Complexity - O(n^2)
     */
    public boolean find() {
        int[][] sol = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sol[i][j] = -1;
            }
        }

        // The possible moves for the Knight
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Knight starts at the first position
        sol[0][0] = 0;

        return solve(0, 0, 1, sol, xMove, yMove);
    }

    public boolean solve(int x, int y, int movei, int[][] sol, int xMove[], int yMove[]) {
        if (movei == n * n) return true;

        int nextX = 0;
        int nextY = 0;
        for (int k = 0; k < 8; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            if (isSafe(nextX, nextY, sol)) {
                // add the move to the solution vector
                sol[nextX][nextY] = movei;
                if (solve(nextX, nextY, movei + 1, sol, xMove, yMove)) return true; // move worked
                else sol[nextX][nextY] = -1; // move did not work. remove move from the solution vector
            }
        }
        return false;
    }

}
