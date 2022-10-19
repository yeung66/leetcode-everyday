class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, left = 0, right = 0, n = arr.length;
        while (left < n) {
            if (right < arr[left]) {
                right = arr[left];
            }

            left++;
            if (left > right) {
                ans++;
                right = left;
            }
        }

        return ans;
    }
}