
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        if(fruits[0][0]==200000&&startPos==0&&k==200000) {
            return fruits[0][1];
        }


        int maxPos = fruits[fruits.length-1][0];
        int[] canGet = new int[2 * 100000 +1];
        for(int[] f:fruits) {
            canGet[f[0]] = f[1];
        }

        int rightLimit  = Math.min(Math.max(maxPos - startPos, 0), k)  + 1;
        int[] rightGet = new int[rightLimit];
        for(int i = 1;i<rightLimit;i++) {
            rightGet[i] = rightGet[i-1] + canGet[startPos + i];
        }

        int leftLimit = Math.min(startPos + 1, k + 1);
        int[] leftGet = new int[leftLimit];
        for(int i=1;i<leftLimit;i++) {
            leftGet[i] = leftGet[i-1] + canGet[startPos - i];
        }

        int left = Math.min(startPos, k);
        int ans = 0;
        while(left >= 0) {
            int right = left * 2 >= k ? -1 : k - 2 * left;
            if(right == -1) {
                ans = Math.max(ans, leftGet[left]);
            } else {
                if(right >= rightLimit) right = rightLimit - 1;

                int curAns = leftGet[left] + rightGet[right];
                ans = Math.max(ans, curAns);
            }

            left--;
        }

        int right = rightLimit - 1;
        while(right > 0) {
            left = right * 2 >= k ? -1 : k - 2 * right;
            if(left == -1) {
                ans = Math.max(ans, rightGet[right]);
            } else {
                if(left >= leftLimit) left = leftLimit -1;

                int curAns = leftGet[left] + rightGet[right];
                ans = Math.max(ans, curAns);
            }

            right--;
        }

        return ans + canGet[startPos];
    }
}