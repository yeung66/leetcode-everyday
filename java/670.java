class Solution {
    public int maximumSwap(int num) {
        if (num < 10) return num;

        List<Integer> digits = new LinkedList<>();
        Map<Integer, Integer> allIdx = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);

        int maxDigit=0;
        int idx = 0, maxIdx = 0;
        while (num > 0) {
            int digit = num % 10;
            if (!allIdx.containsKey(digit)) {
                allIdx.put(digit, idx);
                pq.offer(digit);
            }
            digits.add(digit);
            num = num / 10;
            idx++;
        }

        boolean swap = false;

        while (!swap && !pq.isEmpty()) {
            maxDigit = pq.poll();
            maxIdx = allIdx.get(maxDigit);

            for (int i=digits.size()-1;i>maxIdx;i--) {
                if (digits.get(i) < maxDigit) {
                    digits.set(maxIdx, digits.get(i));
                    digits.set(i, maxDigit);
                    swap = true;
                    break;
                }  
            }
        }

        

        int ans = 0, times = 1;
        for (int d:digits) {
            // System.out.println(d);
            ans += times * d;
            times *= 10;
        }

        return ans;
    }
}