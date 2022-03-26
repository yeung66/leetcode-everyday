class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> records = new Stack<>();
        for (String i:ops) {
            if (i.equals("+")) {
                int temp = records.pop();
                int cur = temp + records.peek();
                records.push(temp);
                records.push(cur);
            } else if (i.equals("D")) {
                records.push(records.peek() * 2);
            } else if (i.equals("C")) {
                records.pop();
            } else {
                records.push(Integer.valueOf(i));
            }
        }

        int ans = 0;
        while (!records.isEmpty()) {
            ans += records.pop();
        }

        return ans;
    }
}