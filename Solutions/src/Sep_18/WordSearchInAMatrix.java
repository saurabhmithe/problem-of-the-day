package Sep_18;

public class WordSearchInAMatrix {

    /*

    Given a 2D matrix of characters and a target word, write a function that returns whether
    the word can be found in the matrix by going left-to-right, or up-to-down.

    For example, given the following matrix:

    [['F', 'A', 'C', 'I'],
     ['O', 'B', 'Q', 'P'],
     ['A', 'N', 'O', 'B'],
     ['M', 'A', 'S', 'S']]

    and the target word 'FOAM', you should return true, since it's the leftmost column.
    Similarly, given the target word 'MASS', you should return true, since it's the last row.

    */

    public static void main(String[] args) {
        char[][] matrix = {{'F', 'A', 'C', 'I'}, {'O', 'B', 'Q', 'P'}, {'A', 'N', 'O', 'B'}, {'M', 'A', 'S', 'S'}};
        WordSearchInAMatrix wordSearchInAMatrix = new WordSearchInAMatrix();
        String word = "FOAM";
        boolean isPresent = wordSearchInAMatrix.search(matrix, word);
        System.out.println(isPresent);
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public boolean search(char[][] matrix, String word) {
        boolean found = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == word.charAt(0)) {
                    found = searchHorizontal(matrix, i, j + 1, word);
                    if (!found) found = searchVertical(matrix, i + 1, j, word);
                    if (found) return true;
                }
            }
        }
        return found;
    }

    public boolean searchHorizontal(char[][] matrix, int i, int j, String word) {
        int count = 1;
        for (int start = j; start < matrix.length; start++) {
            if (matrix[i][start] == word.charAt(count)) count += 1;
            else break;
            if (count == word.length()) return true;
        }
        return false;
    }

    public boolean searchVertical(char[][] matrix, int i, int j, String word) {
        int count = 1;
        for (int start = i; start < matrix.length; start++) {
            if (matrix[start][j] == word.charAt(start)) count += 1;
            else break;
            if (count == word.length()) return true;
        }
        return false;
    }

}
