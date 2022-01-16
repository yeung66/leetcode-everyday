import java.util.*;

class Solution {

    // method2: 
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long sum = Arrays.stream(batteries).mapToLong(i -> i).sum();
        for (int i = batteries.length - 1; i >= 0;i--) {
            if (batteries[i] > sum / n) {
                n--;
                sum -= batteries[i];
            } else {
                break;
            }
        }

        return sum / n;
    }

    
    // method1: 二分
    // public long maxRunTime(int n, int[] batteries) {
    //     long left = 0, right = 1000000001;
    //     while (left < right) {
    //         long mid = (left + right) / 2;
    //         if (check(mid, batteries, n)) {
    //             left = mid + 1;
    //         } else {
    //             right = mid;
    //         }
    //     }

    //     return left - 1;
    // }
    
    // public boolean check(long t, int[] batteries, int n) {
    //     long ans = 0;
    //     for (var b : batteries) {
    //         ans += Math.min(t, b);
    //     }

    //     return ans >= n * t;
    // }
}