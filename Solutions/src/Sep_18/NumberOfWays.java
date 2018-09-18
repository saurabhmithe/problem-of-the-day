package Sep_18;

public class NumberOfWays {

    public static void main(String[] args) {
        int[][] maze = new int[9][9];
        NumberOfWays numberOfWays = new NumberOfWays();
        int noOfWays = numberOfWays.findWays(maze);
        System.out.println(noOfWays);
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(n^2)
     */
    public int findWays(int[][] a) {
        int[][] ways = new int[a.length + 1][a.length + 1];
        int i = 0;
        int j = 0;
        for (i = 0; i < ways.length; i++) {
            ways[0][i] = 1;
            ways[i][0] = 1;
        }
        for (i = 1; i < ways.length; i++) {
            for (j = 1; j < ways.length; j++) {
                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }
        return ways[i - 1][j - 1];
    }

}
