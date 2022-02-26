// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S, int[] X, int[] Y) {
        // write your code in Java SE 11
        long[] distance1 = new long[26];
        long[] distance2 = new long[26];
        for (int i = 0; i < 26; i++) {
            distance1[i] = Long.MAX_VALUE;
            distance2[i] = Long.MAX_VALUE;
        }

        int n = S.length();
        for (int i = 0; i < n; i++) { 
            long d = X[i] * X[i] + Y[i] * Y[i];
            int tagIdx = S.charAt(i) - 'A';
            if (d < distance1[tagIdx]) {
                distance2[tagIdx] = distance1[tagIdx];
                distance1[tagIdx] = d;
            } else if (d < distance2[tagIdx]) {
                distance2[tagIdx] = d;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                if (distance1[i] > distance1[j]) {
                    long temp = distance1[i];
                    distance1[i] = distance1[j];
                    distance1[j] = temp;
                    temp = distance2[i];
                    distance2[i] = distance2[j];
                    distance2[j] = temp;
                }
            }
        }

        Queue<Long> queue = new PriorityQueue<>((i1, i2) -> (int) (i2 - i1));

        int point = 0;
        for (int i = 0; i < 26; i++) {
            long dis = distance1[i];
            if (dis == Long.MAX_VALUE) {
                break;
            }

            long r = (long) Math.ceil(Math.sqrt(dis));
            if (distance2[i] != Long.MAX_VALUE) {
                queue.offer(distance2[i]);
            }

            if (!queue.isEmpty() && r * r > queue.peek()) {
                break;
            }

            point++;
        }
        
        return point;
    }
}
