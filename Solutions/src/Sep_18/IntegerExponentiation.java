package Sep_18;

public class IntegerExponentiation {
    
    /*

    Implement integer exponentiation. That is, implement the pow(x, y) function,
    where x and y are integers and returns x^y.
    Do this faster than the naive method of repeated multiplication.
    For example, pow(2, 10) should return 1024.

    */

    public static void main(String[] args) {
        IntegerExponentiation integerExponentiation = new IntegerExponentiation();
        long result = integerExponentiation.pow(10, 10);
        System.out.println(result);

        result = integerExponentiation.powSquaring(10, 10);
        System.out.println(result);
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * Algorithmic Paradigm - Divide & Conquer
     */
    public long pow(int x, int y) {
        if (y == 0) return 1;
        if (y == 1) return x;
        return x * pow(x, y - 1);
    }

    /**
     * Time Complexity - O(lg n)
     * Space Complexity - O(1)
     * Algorithmic Paradigm - Divide & Conquer
     */
    public long powSquaring(int x, int y) {
        if (y == 0) return 1;
        long temp = powSquaring(x, y / 2);
        if (y % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

}
