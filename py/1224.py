
from collections import Counter

class Solution:
    def maxEqualFreq(self, nums: List[int]) -> int:
        freq, count = Counter(), Counter()
        ans = maxFreq = 0
        for i, num in enumerate(nums):
            if count[num]:
                freq[count[num]] -= 1
            count[num] += 1
            maxFreq = max(maxFreq, count[num])
            freq[count[num]] += 1
            if maxFreq == 1 or \
               freq[maxFreq] * maxFreq + freq[maxFreq - 1] * (maxFreq - 1) == i + 1 and freq[maxFreq] == 1 or \
               freq[maxFreq] * maxFreq + 1 == i + 1 and freq[1] == 1:
                ans = max(ans, i + 1)
        return ans


# from collections import defaultdict
# class Solution:
#     def maxEqualFreq(self, nums: List[int]) -> int:
#         cnt = defaultdict(int)
#         for i in nums:
#             cnt[i] += 1

#         occursCnt = defaultdict(set)
#         for key, val in cnt.items():
#             occursCnt[val].add(key)

#         def ok():
#             if len(occursCnt) > 2 or len(occursCnt) == 0:
#                 return False

#             if len(occursCnt) == 1:
#                 for key, val in occursCnt.items():
#                     if key == 1 or len(val) == 1:
#                         return True

#                 return False

#             eles = [(k, v) for k, v in occursCnt.items()]
#             eles.sort(key = lambda x:x[0])
#             if (eles[0][0] == 1 and len(eles[0][1]) == 1) or (eles[1][0] == eles[0][0] + 1 and len(eles[1][1]) == 1):
#                 return True

#             return False
        
#         # print(cnt, occursCnt)
#         n = len(nums)
#         if ok():
#             return n

                
#         for i in range(n-1, -1, -1):            
#             occursCnt[cnt[nums[i]]].remove(nums[i])
#             if len(occursCnt[cnt[nums[i]]]) == 0:
#                 del occursCnt[cnt[nums[i]]]

#             cnt[nums[i]] -= 1
#             if cnt[nums[i]] != 0:
#                 occursCnt[cnt[nums[i]]].add(nums[i])

#             # print(cnt, occursCnt)
#             if ok():
#                 return i

            

#         return 1
