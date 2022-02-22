import java.util.*;


class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> cnt = new HashMap<>();
        Queue<Character> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (var c : s.toCharArray()) {
            if (cnt.containsKey(c)) {
                cnt.put(c, cnt.get(c) + 1);
            } else {
                cnt.put(c, 1);
                queue.add(c);
            }
        }

        int prevCnt = 0;
        char prevChar = ' ';
        StringBuffer sb = new StringBuffer();

        while (!queue.isEmpty()) {
            char head = queue.poll();
            if (head != prevChar) {
                sb.append(head);
                prevChar = head;
                prevCnt = 1;
                if (cnt.get(head) > 1) {
                    cnt.put(head, cnt.get(head) - 1);
                    queue.offer(head);
                }

            } else {
                if (prevCnt < repeatLimit) {
                    sb.append(head);
                    prevCnt++;
                    if (cnt.get(head) > 1) {
                        cnt.put(head, cnt.get(head) - 1);
                        queue.offer(head);
                    }
                } else {
                    if (queue.isEmpty()) {
                        break;
                    }

                    char second = queue.poll();
                    sb.append(second);
                    prevChar = second;
                    prevCnt = 1;
                    if (cnt.get(second) > 1) {
                        cnt.put(second, cnt.get(second) - 1);
                        queue.offer(second);

                    }
                    queue.offer(head);
                }
            }
        }
        
        return sb.toString();
    }
}