import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public long minimumPerimeter(long neededApples) {
        long left = 1, right = 10000000;
        while (left < right) {
            long M = (left + right) / 2;
            long apples = (1 + M) * M * (2 * M + 1) * 2;
            if (apples >= neededApples) {
                right = M;
            } else {
                left = M + 1;
            }

        }
        return left * 8;
    }

    public static void main(String[] args) {

        // System.out.println(new Solution().minimumPerimeter(100000000000000L));
        System.out.println(new Solution().minimumPerimeter(1000000000));
    }
}