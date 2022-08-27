class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        this.target = target;
        int s = getSteps(new int[]{0,0});
        for (int[] g:ghosts) {
            // if (check(g)) { // 没有必要
            //     // System.out.printf("%d %d\n", g[0], g[1]);
            //     return false;
            // }
            if (getSteps(g) <= s) return false;
        }

        return true;
    }

    // public boolean check(int[] g) {
    //     if (target[0] >= 0 && target[1] >= 0) {
    //         return (0 <= g[0] && g[0] <= target[0] && 0 <= g[1] && g[1] <= target[1]);
    //     } else if (target[0] >= 0 && target[1] < 0) {
    //         return (0 <= g[0] && g[0] <= target[0] && 0 <= -g[1] && -g[1] <= -target[1]);
    //     } else if (target[0] < 0 && target[1] >= 0) {
    //         return (0 <= -g[0] && -g[0] <= -target[0] && 0 <= g[1] && g[1] <= target[1]);
    //     } 
    //         return (0 <= -g[0] && -g[0] <= -target[0] && 0 <= -g[1] && -g[1] <= -target[1]);
        
    // }

    int[] target;

    public int getSteps(int[] point) {
        return Math.abs(point[0] - target[0]) + Math.abs(point[1]-target[1]);
    }
}