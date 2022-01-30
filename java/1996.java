import java.util.Arrays;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (i1, i2) -> i2[0] - i1[0]);
        int max2 = 0, ans = 0, newMax2 = properties[0][1];

        for (int i = 1; i < properties.length; i++) {
            if (properties[i][0] != properties[i - 1][0]) {
                max2 = Math.max(max2, newMax2);
                newMax2 = 0;
            }

            if (properties[i][1] < max2) {
                ans++;
            }
            
            newMax2 = Math.max(newMax2, properties[i][1]);
            
        }

        return ans;
    }
}