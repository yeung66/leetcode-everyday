class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=n-1;i>=0;i--) {
            ans[i] = prices[i];
            while (!stack.empty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            if (!stack.empty()) {
                ans[i] -= stack.peek();
            }

            
            stack.push(prices[i]);
        }

        return ans;
    }
}