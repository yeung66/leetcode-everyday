#!/bin/python
# -*- coding: utf8 -*-
import sys
import os
import re

class Solution:
    def longestWPI(self, hours):
        # Write Code Here 
        n = len(hours)
        pl = [1 if i > 8 else -1 for i in hours]
        ans = 0
        for i in range(n):
            for j in range(i, n):
                if sum(pl[i:j+1]) > 0:
                    # print(i, j)
                    ans = max(ans, j - i + 1)

        return ans

hours_cnt = int(input())
hours = []
for _ in range(hours_cnt):
    hours.append(int(input()))


s = Solution()
res = s.longestWPI(hours)

print(res)