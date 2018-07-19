package Jul_18;

public class ProductOfArrayExceptSelf {

    /*

    Given an array nums of n integers where n > 1, return an array output such that
    output[i] is equal to the product of all the elements of nums except nums[i].

    Example:
    Input:  [1,2,3,4]
    Output: [24,12,8,6]

    Note: Please solve it without division and in O(n).

    Follow up:
    Could you solve it with constant space complexity? (The output array does
    not count as extra space for the purpose of space complexity analysis.)

    */

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
        ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();
        int[] res = product.productExceptSelf(a);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }

}
