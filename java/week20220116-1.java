import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % k == 0) {
                if (sb.length() != 0)
                    ans.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(s.charAt(i));
        }

        while (sb.length() != 0 && sb.length() < k) {
            sb.append(fill);
        }

        ans.add(sb.toString());
        return ans.toArray(new String[0]);
    }
}