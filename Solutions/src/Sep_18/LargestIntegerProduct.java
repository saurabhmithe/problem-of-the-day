package Sep_18;

public class LargestIntegerProduct {

    /*

    Given a list of integers, return the largest product that can be made by multiplying any three integers.
    For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.
    You can assume the list has at least three integers.

    */

    public static void main(String[] args) {
        int[] a = {-10, -10, 5, 2};
        LargestIntegerProduct largestIntegerProduct = new LargestIntegerProduct();
        int result = largestIntegerProduct.find(a);
        System.out.println(result);
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int find(int[] a) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int n : a) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                max3 = max2;
                max2 = n;
            } else if (n >= max1) {
                max3 = n;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

}
