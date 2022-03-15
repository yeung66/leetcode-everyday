class Solution {
    public String minNumber(int[] nums) {
        Queue<String> queue = new PriorityQueue<String>((i1, i2) -> {
            String temp1 = i1 +  i2, temp2 = i2 + i1;
            if (temp1.compareTo(temp2) < 0) {
                return -1;
            } 
            return 1;
        });

        
        for (var i:nums) {
            queue.offer(String.valueOf(i));
        }

        while (queue.size() > 1) {
            String part1 = queue.poll(), part2 = queue.poll();
            String temp1 = part1 +  part2, temp2 = part2 + part1;
            if (temp1.compareTo(temp2) < 0) {
                queue.offer(temp1);
            } else {
                queue.offer(temp2);
            }
        }

        return queue.poll();
    }
}