package Sep_18;

import java.util.Random;

public class UnbiasedCoinToss {

    /*

    Assume you have access to a function toss_biased() which returns 0 or 1 with a probability
    that's not 50-50 (but also not 0-100 or 100-0). You do not know the bias of the coin.
    Write a function to simulate an unbiased coin toss.

    */

    public static void main(String[] args) {
        UnbiasedCoinToss unbiasedCoinToss = new UnbiasedCoinToss();
        for (int i = 0; i < 10; i++) {
            System.out.println(unbiasedCoinToss.toss_unbiased());
        }
    }

    /**
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     */
    private int toss_unbiased() {
        int v1 = toss_biased();
        int v2 = toss_biased();

        if (v1 == 0 && v2 == 1) return 0;
        if (v1 == 1 && v2 == 0) return 1;
        return toss_biased();
    }

    private int toss_biased() {
        Random random = new Random();
        int value = random.nextInt(3);
        if (value == 0) return 0;
        else return 1;
    }

}
