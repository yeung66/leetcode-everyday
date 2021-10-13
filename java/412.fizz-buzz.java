import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 *
 * https://leetcode-cn.com/problems/fizz-buzz/description/
 *
 * algorithms
 * Easy (67.40%)
 * Likes:    134
 * Dislikes: 0
 * Total Accepted:    91.5K
 * Total Submissions: 131K
 * Testcase Example:  '3'
 *
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1
 * 开始）返回结果，其中：
 * 
 * 
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i 如果上述条件全不满足。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 5
 * 输出：["1","2","Fizz","4","Buzz"]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：n = 15
 * 
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        return IntStream.range(1, n + 1)
            .boxed()
            .map(x -> {
                if(x%3==0) {
                    if(x%5==0) return "FizzBuzz";
                    else return "Fizz";
                }

                if(x%5==0) {
                    return "Buzz";
                }
                return String.valueOf(x);
            })
                .collect(Collectors.toList());
    }
}
// @lc code=end

