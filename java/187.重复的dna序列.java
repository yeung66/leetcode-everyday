import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 *
 * https://leetcode-cn.com/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (48.38%)
 * Likes:    241
 * Dislikes: 0
 * Total Accepted:    54.4K
 * Total Submissions: 108K
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA
 * 中的重复序列有时会对研究非常有帮助。
 * 
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * s[i] 为 'A'、'C'、'G' 或 'T'
 * 
 * 
 */

// @lc code=start
class Solution {
    static int L = 10;
    Map<Character, Integer> bin = new HashMap<>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);    
        }
    };

    public List<String> findRepeatedDnaSequences(String s) {
        // method 1
        // Map<String, Integer> seqs = new HashMap<>();
        // for (var i = 0; i <= s.length() - 10; i++) {
        //     var sub = s.substring(i, i + 10);
        //     seqs.put(sub, seqs.getOrDefault(sub, 0) + 1);
        // }

        // return seqs.keySet().stream().filter(c -> seqs.get(c) > 1).collect(Collectors.toList());

        // method 2
        int n = s.length();
        List<String> ans = new ArrayList<>();
        if (n <= L)
            return ans;

        int x = 0;
        for (var i = 0; i < L - 1; i++) {
            x = (x << 2) | bin.get(s.charAt(i));
        }

        Map<Integer, Integer> count = new HashMap<>();
        int bits =  ((1 << (L * 2)) - 1);
        for (var i = L - 1; i < n; i++) {
            x = ((x << 2) | bin.get(s.charAt(i))) & bits;
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 2) {
                ans.add(s.substring(i - L + 1, i + 1));
            }
        }

        return ans;
    }
}
// @lc code=end

