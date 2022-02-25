class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0)
            return false;

        int idx = 0;
        idx = parseNum(idx, s, false);
        if (idx == -1)
            return false;

        if (idx < s.length()) {
            if (s.charAt(idx) == 'e' || s.charAt(idx) == 'E') {
                idx++;
                if (idx < s.length()) {
                    idx = parseNum(idx, s, true);
                    if (idx != -1)
                        return true;
                }

            }

            return false;
        }

        return true;
    }

    public int parseNum(int idx, String s, boolean integer) {
        char c = s.charAt(idx);
        if (c == '+' || c == '-')
            idx++;

        int dotCnt = 0, numCnt = 0;
        while (idx < s.length()) {
            c = s.charAt(idx);
            if (isDigit(c)) {
                idx++;
                numCnt++;
            } else if (!integer && c == '.') {
                if (dotCnt >= 1)
                    return -1;
                dotCnt++;
                idx++;
            } else if (!integer && (c == 'e' || c == 'E')) {
                break;
            } else {
                return -1;
            }
        }

        if (numCnt == 0)
            return -1;
        return idx;
    }

    public boolean isDigit(char c) {
        return c <= '9' && c >= '0';
    }
}