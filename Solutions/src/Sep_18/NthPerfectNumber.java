package Sep_18;

public class NthPerfectNumber {

    /*

    A number is considered perfect if its digits sum up to exactly 10.
    Given a positive integer n, return the n-th perfect number.
    For example, given 1, you should return 19. Given 2, you should return 28.

    */

    public static void main(String[] args) {
        NthPerfectNumber nthPerfectNumber = new NthPerfectNumber();
        int result = nthPerfectNumber.find(9999);
        System.out.println(result);
    }

    public int find(int n) {
        if (n > 9999) return -1; // stopping it here since the calculation goes on forever
        int count = 0;
        for (int i = 19; ; i += 9) {
            int sum = 0;
            for (int j = i; j > 0; j /= 10) {
                sum += j % 10;
            }
            if (sum == 10) count += 1;
            if (count == n) return i;
        }
    }

}
