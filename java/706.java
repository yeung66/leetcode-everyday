import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

class MyHashMap {

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int BASE = 769;

    private int hash(int key) {
        return key % array.length;
    }

    private final LinkedList[] array = new LinkedList[BASE];

    public MyHashMap() {
        Arrays.fill(array, null);
    }

    public void put(int key, int value) {
        int h = hash(key);
        if (array[h] == null) {
            array[h] = new LinkedList<Pair>();
            array[h].add(new Pair(key, value));
            return;
        }

        for (Pair pair : (LinkedList<Pair>) array[h]) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }

        array[h].add(new Pair(key, value));
    }

    public int get(int key) {
        int h = hash(key);
        if (array[h] == null) {
            return -1;
        }

        for (Pair pair : (LinkedList<Pair>) array[h]) {
            if (pair.key == key) {
                return pair.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        if (array[h] == null) {
            return;
        }

        for (Pair pair : (LinkedList<Pair>) array[h]) {
            if (pair.key == key) {
                array[h].remove(pair);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */