package Sep_18;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LeastFrequentlyUsedCache {

    /*

    Implement an LFU (Least Frequently Used) cache. It should be able to be
    initialized with a cache size n, and contain the following methods:

    set(key, value): sets key to value. If there are already n items in the cache and we are
    adding a new item, then it should also remove the least frequently used item.
    If there is a tie, then the least recently used key should be removed.

    get(key): gets the value at key. If no such key exists, return null.

    Each operation should run in O(1) time.

    */

    int capacity;
    int minimum;
    HashMap<Integer, Integer> values;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;

    public static void main(String[] args) {

    }

    public LeastFrequentlyUsedCache(int size) {
        capacity = size; // size of the cache
        values = new HashMap<>(); // a hash-map storing actual keys and values
        counts = new HashMap<>(); // a hash-map storing the frequency of the keys
        lists = new HashMap<>(); // a hash-map storing the frequency and keys with those frequencies
        lists.put(1, new LinkedHashSet<>());
    }

    public void set(Integer key, int value) {
        // not enough storage to store the new data
        if (capacity <= 0) return;

        // key already present. just assign the new value to the key
        if (values.containsKey(key)) {
            values.put(key, value);

            return;
        }

        // the cache is full and we need to remove the least frequently used
        if (values.size() >= capacity) {
            int lfu = lists.get(minimum).iterator().next(); // get the key with the minimum frequency
            lists.get(minimum).remove(lfu); // remove the entry from the frequency-key map
            values.remove(lfu); // remove the pair from the key-value map
        }

        values.put(key, value); // add the new value to the cache now that the lfu is removed and we have space
        counts.put(key, 1); // update the count for the new key as 1
        minimum = 1; // set the minimum to 1 as we now have a key appeared only once and thus is the least frequent
        lists.get(1).add(key); // add the key to the frequency-key map at frequency "1"
    }

    public Integer get(Integer key) {
        // if key-value map does not contain the key
        if (!values.containsKey(key)) return null;

        counts.put(key, counts.get(key) + 1); // since the key has been accessed one more time, increment the frequency
        int oldCount = counts.get(key) - 1;
        lists.get(oldCount).remove(key); // remove the key from the frequency-key hash-map since the frequency changed

        // if the count was minimum and there was no key for that frequency
        if (oldCount == minimum && lists.get(oldCount).size() == 0) minimum++;

        //if the new updated frequency is not present in the frequency-key hash-map, create an entry for it
        if (!lists.containsKey(oldCount + 1)) lists.put(oldCount + 1, new LinkedHashSet<>());

        // add the key to the newly created entry
        lists.get(oldCount + 1).add(key);

        // return the value for the requested key
        return values.get(key);
    }

}
