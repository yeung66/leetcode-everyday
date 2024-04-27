import java.util.*;
class SnapshotArraySimple {

    private class ArrayNode {
        int val;
        int snapId;
        ArrayNode next;

        public ArrayNode(int val, int snapId) {
            this.val = val;
            this.snapId = snapId;
        }
    }

    private List<ArrayNode> arrays;

    private int snapId;

    public SnapshotArraySimple(int length) {
        arrays = new ArrayList<>(length);
        snapId = 0;
        for (int i = 0; i < length; i++) {
            arrays.add(new ArrayNode(0, 0));
        }
    }

    public void set(int index, int val) {
        ArrayNode node = arrays.get(index);
        while (node.next != null) {
            node = node.next;
        }

        if (snapId == node.snapId) {
            node.val = val;
        } else {
            node.next = new ArrayNode(val, snapId);
        }


    }

    public int snap() {
        snapId++;
        return snapId - 1;
    }

    public int get(int index, int snap_id) {
        ArrayNode node = arrays.get(index);
        while (node.next != null) {
            if (node.next.snapId > snap_id) return node.val;
            node = node.next;
        }

        return node.val;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */