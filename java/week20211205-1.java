import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> ans = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0)
                continue;

            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                for (int k = 0; k < n; k++) {
                    if (k == j || k == i)
                        continue;
                    if (digits[k] % 2 == 0)
                        ans.add(100 * digits[i] + 10 * digits[j] + digits[k]);
                }
            }
        }

        return ans.stream().sorted().mapToInt(i->i).toArray();
    }
}