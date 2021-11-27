// https://leetcode-cn.com/problems/shortest-way-to-form-string/

class Solution {


    public int shortestWay(String source, String target) {

        int sidx = 0, tidx = 0, ans = 0;
        while (tidx < target.length()) {
            int find = source.indexOf(target.charAt(tidx), sidx);
            if (find == -1) {
                if (sidx == 0)
                    return -1;
                sidx = 0;
                ans++;
            } else {
                tidx++;
                sidx = find + 1;
            }
        }

        return sidx == 0 ? ans : ans + 1;
    }
}