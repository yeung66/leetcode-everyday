from itertools import pairwise
from typing import List
from collections import defaultdict, deque

class Solution:
    def sequenceReconstruction(self, nums: List[int], sequences: List[List[int]]) -> bool:
        n = len(nums)
        graph = [set() for _ in range(n+1)]
        indegrees = [0 for _ in range(n+1)]
        for seq in sequences:
            for i,val in enumerate(seq[:-1]):
                graph[val].add(seq[i+1])
                indegrees[seq[i+1]] += 1

        q = deque([i+1 for i, d in enumerate(indegrees[1:]) if d == 0])
        while q:
            if len(q) > 1:
                return False

            node = q.popleft()
            for v in graph[node]:
                indegrees[v] -= 1
                if indegrees[v] == 0:
                    q.append(v)

        return True

            





