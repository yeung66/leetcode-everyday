class Solution {
    public int findCenter(int[][] edges) {
        int ans1 = edges[0][0], ans2 = edges[0][1];
        return edges[1][0] == ans1 || edges[1][0] == ans2 ? edges[1][0] : edges[1][1];
    }
}