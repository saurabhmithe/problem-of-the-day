public class _2_ProductOfArrayExceptSelf {

    /*

    Given an array of integers, return a new array such that each element at index i of the
    new array is the product of all the numbers in the original array except the one at i.

    For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
    If our input was [3, 2, 1], the expected output would be [2, 3, 6].

    Follow-up: what if you can't use division?

    */

    /**
     * APPROACH 1
     * This is a simple approach where we find out the product of the entire array
     * and then for value at each position, just divide the product by the original value
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int[] productExceptSelfWithDivision(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        for (int n : nums) product *= n;
        for (int i = 0; i < res.length; i++) res[i] = product / nums[i];
        return res;
    }

    /**
     * The idea is to use two passes over the input array and store the result in the result array.
     * In the first pass, starting ayt 0 we multiply the value at index i with all the values at the indexes before i.
     * Similarly, in the second pass, starting at last index we multiply the value with all values to the right.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return nums;
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        _2_ProductOfArrayExceptSelf product = new _2_ProductOfArrayExceptSelf();
        int[] res = product.productExceptSelf(a);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }

}
