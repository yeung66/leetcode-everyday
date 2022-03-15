class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;

        long digit = 1, numsCnt = 9, start = 1;
        while (n > numsCnt * digit) {
            n -= numsCnt * digit;
            numsCnt *= 10;
            digit++;
            start *= 10;
        }


        long th = start + (n - 1) / digit;
        String target = String.valueOf(th);
        // System.out.println(target);
        return target.charAt((n-1) % (int) digit) - '0';
    }
}