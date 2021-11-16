import java.util.*;

/*
 * @lc app=leetcode.cn id=677 lang=java
 *
 * [677] 键值映射
 *
 * https://leetcode-cn.com/problems/map-sum-pairs/description/
 *
 * algorithms
 * Medium (61.65%)
 * Likes:    178
 * Dislikes: 0
 * Total Accepted:    34.5K
 * Total Submissions: 51.9K
 * Testcase Example:  '["MapSum","insert","sum","insert","sum"]\n' +
  '[[],["apple",3],["ap"],["app",2],["ap"]]'
 *
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 * 
 * 
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键
 * key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 * 
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);  
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);    
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * key 和 prefix 仅由小写英文字母组成
 * 1 
 * 最多调用 50 次 insert 和 sum
 * 
 * 
 */

// @lc code=start
class MapSum {

    private Map<String, Integer> map;
    private Trie trie;

    public MapSum() {
        trie = new Trie(0);
        map = new HashMap<>();

    }
    
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        trie.insert(key, delta);
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        return trie.search(prefix);
    }

    class Trie {
        Map<Character, Trie> children;
        int val;

        public Trie(int val) {
            children = new HashMap<>();
            this.val = val;
        }

        public void insert(String word, int val) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children.containsKey(c)) {
                    cur = cur.children.get(c);
                    cur.val += val;
                } else {
                    Trie t = new Trie(val);
                    cur.children.put(c, t);
                    cur = t;
                }
            }
        }
        
        public int search(String prefix) {
            Trie cur = this;
            for (char c : prefix.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    return 0;
                }

                cur = cur.children.get(c);
            }

            return cur.val;
        }

    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end

