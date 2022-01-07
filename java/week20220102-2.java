import java.util.*;

class Solution {
    public int numberOfBeams(String[] bank) {
        int[] devices = new int[bank.length];
        for (int j = 0; j < bank.length; j++) {
            String row = bank[j];
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '1') {
                    devices[j]++;
                }
            }

        }
        
        int count = 0;
        for (int i = 0; i < bank.length; i++) {
            if (devices[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < bank.length; j++) {
                if (devices[j] == 0) {
                    continue;
                } else {
                    System.out.printf("%d %d\n", devices[i], devices[j]);
                    count += devices[i] * devices[j];
                    break;
                }

            }
        }
        
        return count;
    }
}