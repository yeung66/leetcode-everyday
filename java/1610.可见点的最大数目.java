import java.util.*;

/*
 * @lc app=leetcode.cn id=1610 lang=java
 *
 * [1610] 可见点的最大数目
 *
 * https://leetcode-cn.com/problems/maximum-number-of-visible-points/description/
 *
 * algorithms
 * Hard (27.12%)
 * Likes:    67
 * Dislikes: 0
 * Total Accepted:    7.5K
 * Total Submissions: 18.2K
 * Testcase Example:  '[[2,1],[2,2],[3,3]]\n90\n[1,1]'
 *
 * 给你一个点数组 points 和一个表示角度的整数 angle ，你的位置是 location ，其中 location = [posx, posy]
 * 且 points[i] = [xi, yi] 都表示 X-Y 平面上的整数坐标。
 * 
 * 最开始，你面向东方进行观测。你 不能 进行移动改变位置，但可以通过 自转 调整观测角度。换句话说，posx 和 posy 不能改变。你的视野范围的角度用
 * angle 表示， 这决定了你观测任意方向时可以多宽。设 d 为你逆时针自转旋转的度数，那么你的视野就是角度范围 [d - angle/2, d +
 * angle/2] 所指示的那片区域。
 * 
 * Your browser does not support the video tag or this video format.
 * 
 * 对于每个点，如果由该点、你的位置以及从你的位置直接向东的方向形成的角度 位于你的视野中 ，那么你就可以看到它。
 * 
 * 同一个坐标上可以有多个点。你所在的位置也可能存在一些点，但不管你的怎么旋转，总是可以看到这些点。同时，点不会阻碍你看到其他点。
 * 
 * 返回你能看到的点的最大数目。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：points = [[2,1],[2,2],[3,3]], angle = 90, location = [1,1]
 * 输出：3
 * 解释：阴影区域代表你的视野。在你的视野中，所有的点都清晰可见，尽管 [2,2] 和 [3,3]在同一条直线上，你仍然可以看到 [3,3] 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：points = [[2,1],[2,2],[3,4],[1,1]], angle = 90, location = [1,1]
 * 输出：4
 * 解释：在你的视野中，所有的点都清晰可见，包括你所在位置的那个点。
 * 
 * 示例 3：
 * 
 * 
 * 
 * 
 * 输入：points = [[1,0],[2,1]], angle = 13, location = [1,1]
 * 输出：1
 * 解释：如图所示，你只能看到两点之一。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * points[i].length == 2
 * location.length == 2
 * 0 
 * 0 x, posy, xi, yi 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameCount = 0;
        int lx = location.get(0), ly = location.get(1);
        List<Double> polarDegrees = new ArrayList<>();
        for (List<Integer> p : points) {
            int x = p.get(0);
            int y = p.get(1);
            if (x == lx && y == ly)
                sameCount++;
            else {
                Double degree = Math.atan2(y - ly, x - lx);
                polarDegrees.add(degree);
            }

        }
        
        Collections.sort(polarDegrees);

        int m = polarDegrees.size();
        for (int i = 0; i < m; i++) {
            polarDegrees.add(polarDegrees.get(i) + 2 * Math.PI);
        }

        int right = 0;
        int ans = 0;
        double angleTran = angle * Math.PI / 180;
        for (int i = 0; i < m; i++) {
            double degree = polarDegrees.get(i) + angleTran;
            while (right < 2 * m && polarDegrees.get(right) <= degree) {
                right++;
            }
            ans = Math.max(ans, right - i);
        }

        return ans + sameCount;
    }
}
// @lc code=end

