package Sep_18;

public class MatrixClockwiseSpiral {

    /*

    Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.

    For example, given the following matrix:

    [[1,  2,  3,  4,  5],
     [6,  7,  8,  9,  10],
     [11, 12, 13, 14, 15],
     [16, 17, 18, 19, 20]]

    You should print out the following: 1 2 3 4 5 10 15 20 19 18 17 16 11 6 7 8 9 14 13 12

    */

    public static void main(String[] args) {
        MatrixClockwiseSpiral matrixClockwiseSpiral = new MatrixClockwiseSpiral();
        int[][] a = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        matrixClockwiseSpiral.printSpiral(a);
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public void printSpiral(int[][] a) {
        int row = a.length - 1;
        int col = a[0].length - 1;
        for (int level = 0; level <= row / 2; level++) {
            for (int i = level; i < col - level; i++) {
                System.out.println(a[level][i]);
            }
            for (int j = level; j < row - level; j++) {
                System.out.println(a[j][col - level]);
            }
            for (int i = col - level; i > level; i--) {
                System.out.println(a[row - level][i]);
            }
            for (int j = row - level; j > level; j--) {
                System.out.println(a[j][level]);
            }
        }
    }

}
