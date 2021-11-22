class Solution {

    // 得到比 str 大的下一个 10 进制对称的数字，例如 1->2, 4->5, 9->11
    public String next(String str) {
        int n = str.length();

        StringBuilder sb = new StringBuilder();
        // 将 str 截断一半，然后 + 1 最后把另一半缺失的数字补齐即可
        long num = Long.parseLong(str.substring(0, (n + 1) / 2));

        // 发生进位，则表示下一个数字的位数是 n + 1 位， 比如 99 下一个对称数字 101 就发生了进位
        if (Long.toString(num + 1).length() != Long.toString(num).length()) {
            for (int i = 0; i <= n; i++) {
                if (i == 0 || i == n) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
        } else {
            sb.append(num + 1);
            for (int i = (n + 1) / 2; i < n; i++) {
                sb.append(sb.charAt(n - 1 - i));
            }
        }

        return sb.toString();
    }

    public long kMirror(int k, int n) {
        long res = 0;

        String str = "1";
        while (n > 0) {
            long i = Long.parseLong(str);
            if (symmetry(Long.toString(i, k))) {
                res += i;
                n--;
            }
            str = next(str);
        }

        return res;
    }

    // 检查字符串是对称
    public boolean symmetry(String str) {
        int n = str.length();
        int s = 0, e = n - 1;
        while (s < e) {
            if (str.charAt(s) != str.charAt(e))
                return false;

            s++;
            e--;
        }

        return true;
    }
}