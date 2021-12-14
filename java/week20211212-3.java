class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0, right = plants.length - 1;
        int curA = capacityA, curB = capacityB;
        int ans = 0;
        while (left <= right) {
            if (left == right) {
                if (curA < plants[left] && curB < plants[left]) {
                    ans++;
                }
                left++;
            } else {
                if (curA < plants[left]) {
                    curA = capacityA;
                    ans++;
                }

                if (curB < plants[right]) {
                    curB = capacityB;
                    ans++;
                }

                curA -= plants[left];
                curB -= plants[right];
                left++;
                right--;
            }
        }

        return ans;
    }
}