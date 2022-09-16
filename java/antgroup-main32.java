import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Map<Integer, Integer> hm = new HashMap<>();
        long res = 0;
        int cur = 0;
        hm.put(0, 1);
        for (char c : str.toCharArray()) {
            cur ^= 1 << (c - 'a');
            // System.out.printf("%26s\n", Integer.toBinaryString(cur));
            for (int i = 0; i < 26; ++i) {
                if (hm.getOrDefault(cur ^ (1 << i), 0) > 0) {
                    // System.out.printf("%26s %d\n", Integer.toBinaryString(cur ^ (1 << i)),
                    hm.get(cur ^ (1 << i)));
                }
                res += hm.getOrDefault(cur ^ (1 << i), 0);
            }
            hm.put(cur, hm.getOrDefault(cur, 0) + 1);
        }
        System.out.println(res);
    }
}