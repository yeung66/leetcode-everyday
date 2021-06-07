import java.util.ArrayList;

class Solution {
    public int reductionOperations(int[] nums) {
        int[] count = new int[50000+1];
        for(int i:nums) count[i]++;
        int ans = 0, times = 0;
        for(int i=1;i<count.length;i++) {
            if(count[i]>0) {
                ans += count[i] * times;
                times++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        var s = new Solution();
        int[] nums = new int[] {5,1,3 };
        System.out.println(s.reductionOperations(nums));
    }
}
