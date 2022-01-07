import java.util.*;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long m = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > m) {
                return false;
            }

            m += asteroids[i];
        }

        return true;
    }
}