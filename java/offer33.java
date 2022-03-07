class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return check(postorder, 0, postorder.length - 1);
    }

    public boolean check(int[] order, int start, int end) {
        if (start >= end)  {
            return true;
        }

        int root = order[end];
        int idx = start;
        while (order[idx] < root) {
            idx++;
        }

        int idx2 = idx;
        while (order[idx2] > root) {
            idx2++;
        }

        return idx2 == end && check(order, start, idx - 1) && check(order, idx, end - 1);
    }
}