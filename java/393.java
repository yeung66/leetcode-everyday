class Solution {
    public boolean validUtf8(int[] data) {
        int highbit = 0x80;
        for (int idx = 0;idx<data.length;) {
            if ((data[idx] & highbit) == 0) {
                idx++;
            } else {
                 int cnt = 0;
                 int bit = highbit >> 1;
                 while (bit > 0 && (data[idx] & bit) > 0) {
                     cnt++;
                     bit >>= 1;
                 }

                 if (cnt >= 4 || cnt ==  0 || idx + cnt >= data.length) return false;
                 for (int j = idx + 1;j <= idx + cnt;j++) {
                     if ((data[j] & highbit) > 0 && ((data[j] ^ 0x40) & 0x40 ) > 0) continue;
                     else return false;
                 }

                 idx = idx + cnt + 1;
            }
        }

        return true;
    }
}