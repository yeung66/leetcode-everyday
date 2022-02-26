// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 11
        int n = A.length;
        int[] minCost = new int[3];
        int[] minIdx = new int[3];
        for (int i = 0; i < 3; i++)
            minCost[i] = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            if (A[i] < minCost[0]) {
                minCost[2] = minCost[1];
                minCost[1] = minCost[0];
                minCost[0] = A[i];
                minIdx[2] = minIdx[1];
                minIdx[1] = minIdx[0];
                minIdx[0] = i;
            } else if (A[i] < minCost[1]) {
                minCost[2] = minCost[1];
                minCost[1] = A[i];
                minIdx[2] = minIdx[1];
                minIdx[1] = i;
            } else if (A[i] < minCost[2]) {
                minCost[2] = A[i];
                minIdx[2] = i;
            }
        }

        // System.out.printf("%d %d %d\n", minCost[0], minCost[1], minCost[2]);
        // System.out.printf("%d %d %d\n", minIdx[0], minIdx[1], minIdx[2]);

        if (Math.abs(minIdx[0] - minIdx[1]) > 1) {
            return minCost[0] + minCost[1];
        } else if (Math.abs(minIdx[0] - minIdx[2]) > 1) {
            return minCost[0] + minCost[1];
        } 
        
        return minCost[1] + minCost[2];
    }
}
