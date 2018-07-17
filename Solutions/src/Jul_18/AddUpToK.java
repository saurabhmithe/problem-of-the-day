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

    public boolean isAddUpToKHashSet(int[] a, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (set.contains(target - a[i])) return true;
            set.add(a[i]);
        }
        return false;
    }

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
