import java.util.LinkedList;

class MyHashSet {

    private final int BASE = 769;
    private LinkedList[] set;

    public MyHashSet() {
        set = new LinkedList[BASE];
    }

    private int hash(int key) {
        return key % BASE;
    }

    public void add(int key) {
        int h = hash(key);
        if (set[h] == null) {
            set[h] = new LinkedList<Integer>();

        }

        if (!set[h].contains(key)) {
            set[h].add(key);
        }
    }

    public void remove(int key) {
        int h = hash(key);
        if (set[h] == null) {
            return;
        }
        set[h].remove((Integer)key);
    }

    public boolean contains(int key) {
        int h = hash(key);
        if (set[h] == null) {
            return false;
        }
        return set[h].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */