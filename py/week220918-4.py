from collections import defaultdict

class Node:
    def __init__(self, c) -> None:
        self.char = c
        self.cnt = 1
        self.next = {}


class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        root = prefix = Node('0')
        for w in words:
            prefix = root
            for j in w:
                if j in prefix.next:
                    prefix = prefix.next[j]
                    prefix.cnt += 1
                else:
                    prefix.next[j] = Node(j)
                    prefix = prefix.next[j]

        ret = []
        for w in words:
            prefix = root
            ans = 0
            for j in w:
                prefix = prefix.next[j]
                ans += prefix.cnt

            ret.append(ans)

        return ret