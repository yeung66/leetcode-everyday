// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] D, int X) {
        // write your code in Java SE 11
        int n = D.length;
        int start = 0, end = 1;
        int max, min;
        int ans = 0;
        while (start < n) {
            max = D[start];
            min = D[start];
            while (end < n) {
                max = Math.max(D[end], max);
                min = Math.min(D[end], min);
                if (max - min > X)
                    break;

                end++;
            }

            ans++;
            start = end;
            end = end + 1;
        }

        return ans;

    }
}
