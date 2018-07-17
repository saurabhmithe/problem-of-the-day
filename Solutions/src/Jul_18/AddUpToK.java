package Jul_18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AddUpToK {

    /*

    Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

    */

    public static void main(String[] args) {
        int[] array = {10, 21, 33, 42, 56, 68, 79, 86, 94};
        AddUpToK addUpToK = new AddUpToK();
        boolean result = addUpToK.isAddUpToKHashSet(array, 104);
        System.out.println(result);
        result = addUpToK.isAddUpToKSorting(array, 104);
        System.out.println(result);
    }

    /**
     * Since we have a the target value, we can find out of two numbers add up to target
     * by looking at a value and then figuring out if target - value exists in the given array.
     * To enable constant time lookup, we can use a Hash Set. For each value in the array,
     * check if target - value exists in the Hash Set. If it does, return true.
     * Else, put the current value in the Hash Set and continue looking.
     * Stop when you find a match or if you have seen all the values in the array already.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public boolean isAddUpToKHashSet(int[] a, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (set.contains(target - a[i])) return true;
            set.add(a[i]);
        }
        return false;
    }

    /**
     * Since we have the target value, we know that addition of two values would give us the target value.
     * We use sorting here. Sorting the values in the array would allow us to check different pairs
     * of values in a systematic way. If the sum of the first and the last value in the sorted array
     * is greater than the target value, we know that we need to check with smaller numbers.
     * So we keep the small number as it is and check the second last i.e. second largest value.
     * Similarly, if the sum is lesser than the target value, we know that we need to check with
     * a greater value, so we check the sum of largest value and second smallest value.
     * If we find a sum equal to target, we stop. Else, we continue doing this until we
     * look at all the elements.
     * <p>
     * Time Complexity - O(nlogn)
     * Space Complexity - O(1)
     */
    public boolean isAddUpToKSorting(int[] a, int target) {
        Arrays.sort(a);
        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            if (a[low] + a[high] == target) return true;
            else if (a[low] + a[high] < target) low += 1;
            else if (a[low] + a[high] > target) high -= 1;
        }
        return false;
    }

}
