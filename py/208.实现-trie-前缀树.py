#
# @lc app=leetcode.cn id=208 lang=python3
#
# [208] 实现 Trie (前缀树)
#
# https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
#
# algorithms
# Medium (68.93%)
# Likes:    419
# Dislikes: 0
# Total Accepted:    57K
# Total Submissions: 82.7K
# Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
#
# 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
# 
# 示例:
# 
# Trie trie = new Trie();
# 
# trie.insert("apple");
# trie.search("apple");   // 返回 true
# trie.search("app");     // 返回 false
# trie.startsWith("app"); // 返回 true
# trie.insert("app");   
# trie.search("app");     // 返回 true
# 
# 说明:
# 
# 
# 你可以假设所有的输入都是由小写字母 a-z 构成的。
# 保证所有输入均为非空字符串。
# 
# 
#

# @lc code=start

class Node:
    def __init__(self, char=''):
        self.char = char
        self.word = ''
        self.children = {}


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.tree = Node()


    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.tree
        for char in word:
            if char not in node.children: node.children[char] = Node()
            node = node.children[char]

        node.word = word

        


    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.tree
        for char in word:
            if char not in node.children: return False
            node = node.children[char]

        return True if node.word == word else False

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.tree
        for char in prefix:
            if char not in node.children: return False
            node = node.children[char]

        return True







# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
# @lc code=end

