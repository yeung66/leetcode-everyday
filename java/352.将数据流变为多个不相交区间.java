import java.util.ArrayList;
import java.util.*;

/*
 * @lc app=leetcode.cn id=352 lang=java
 *
 * [352] 将数据流变为多个不相交区间
 *
 * https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/description/
 *
 * algorithms
 * Hard (59.22%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    8.7K
 * Total Submissions: 13.4K
 * Testcase Example:  '["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals"]\n' +
  '[[],[1],[],[3],[],[7],[],[2],[],[6],[]]'
 *
 *  给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
 * 
 * 实现 SummaryRanges 类：
 * 
 * 
 * 
 * 
 * SummaryRanges() 使用一个空数据流初始化对象。
 * void addNum(int val) 向数据流中加入整数 val 。
 * int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入：
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals",
 * "addNum", "getIntervals", "addNum", "getIntervals", "addNum",
 * "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * 输出：
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7,
 * 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 * 
 * 解释：
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // 返回 [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= val <= 10^4
 * 最多调用 addNum 和 getIntervals 方法 3 * 10^4 次
 * 
 * 
 * 
 * 
 * 
 * 
 * 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 * 
 */

// @lc code=start
class SummaryRanges {
    private List<List<Integer>> ranges;

    public SummaryRanges() {
        this.ranges = new ArrayList<>();
    }

    public void addNum(int val) {
        int mergeCnt = 0, i = 0;
        for (i = 0; i < ranges.size();i++) {
            var range = ranges.get(i);
            if (val < range.get(0) - 1)
                break;
            if (val >= range.get(0) && val <= range.get(1))
                return;
            if (range.get(0) - 1 == val || range.get(1) + 1 == val) {
                range.set(range.get(0) - 1 == val ? 0 : 1, val);
                mergeCnt++;
                if (mergeCnt == 2) {
                    ranges.get(i - 1).set(1, range.get(1));
                    ranges.remove(i);
                    return;
                }
            }
        }
        
        if (mergeCnt == 0) {
            ranges.add(i, new ArrayList<>() {
                {
                    add(val);
                    add(val);
                }
            });
        }
    }

    public int[][] getIntervals() {
        return ranges.stream().map(r -> new int[] { r.get(0), r.get(1) }).toArray(size->new int[size][2]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges(); obj.addNum(val); int[][] param_2 =
 * obj.getIntervals();
 */
// @lc code=end
