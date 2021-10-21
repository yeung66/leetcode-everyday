import java.util.*;
/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 *
 * https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/description/
 *
 * algorithms
 * Medium (48.13%)
 * Likes:    338
 * Dislikes: 0
 * Total Accepted:    42K
 * Total Submissions: 83.6K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n' +
  '[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 
 * 实现词典类 WordDictionary ：
 * 
 * 
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些
 * '.' ，每个 . 都可以表示任何一个字母。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入：
 * 
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * 
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 * 
 * 
 */

// @lc code=start
class WordDictionary {

    DictTreeNode tree;

    public WordDictionary() {
        tree = new DictTreeNode();
    }
    
    public void addWord(String word) {
        tree.insert(word);
    }
    
    public boolean search(String word) {
        return tree.search(word, 0);
    }
}

class DictTreeNode {
    Map<Character, DictTreeNode> sufix = new HashMap<>();
    boolean isWord = false;

    public void insert(String word) {
        DictTreeNode node = this;
        for (var c : word.toCharArray()) {
            if (!node.sufix.containsKey(c)) {
                // System.out.printf("add: %s %s\n", word, c);
                node.sufix.put(c, new DictTreeNode());
            }
            node = node.sufix.get(c);
        }

        node.isWord = true;

    }

    public boolean search(String word, int idx) {
        // DictTreeNode node = this;
        // System.out.printf("%s %d", word, idx);
        if(idx == word.length()) return this.isWord;

        char c = word.charAt(idx);
        if(c == '.') return sufix.values().stream().map(node -> 
            node.search(word, idx + 1)
            ).anyMatch(x -> x);

        
        if (!sufix.containsKey(c))
            return false;
        return sufix.get(c).search(word, idx + 1);            
        
    }
    

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

