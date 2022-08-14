#!/bin/python
# -*- coding: utf8 -*-
from collections import defaultdict
import sys
import os
import re

class Solution:
    def containsNearbyDuplic(self, nums, k):
        # Write Code Here 
        n = len(nums)
        # for i in range(n):
        #     for j in range(i + 1, min(i + k + 1, n)):
        #         if nums[i] == nums[j]:
        #             return 'true'

        # return 'false'
        # for i in range(n):
        #     for j in range(n):
        #         if i != j and abs(i - j) <= k:
        #             return 'true'

        # return 'false'
        cnt = defaultdict(list)
        for i in range(n):
            cnt[nums[i]].append(i)

        for _, val in cnt.items():
            if len(val) > 1:
                for i, idx in enumerate(val[1:]):
                    if idx - val[i] <= k:
                        return 'true'

        return 'false'


nums_cnt = int(input())
nums = []
for _ in range(nums_cnt):
    nums.append(int(input()))

k = int(input())


s = Solution()
res = s.containsNearbyDuplic(nums, k)

print(res)