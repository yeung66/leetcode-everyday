#
# @lc app=leetcode.cn id=918 lang=python3
#
# [918] 环形子数组的最大和
#

# @lc code=start
class Solution:
    def maxSubarraySumCircular(self, A: List[int]) -> int:

        # method 2
        # P = A * 2
        # for i in range(1,len(P)):
        #     P[i] = P[i] + P[i-1]

        # from collections import deque
        # queue = deque([0])
        # ans = A[0]
        # for j in range(1,len(P)):
        #     i = queue[0]
        #     if j-i > len(A):
        #         queue.popleft()
        #         i = queue[0]
        #     ans = max(ans, P[j]-P[i])

        #     while queue and P[queue[-1]] > P[j]:
        #         queue.pop()

        #     queue.append(j)
        # return ans

        # method 2
        # ans = cur = A[0]
        # N = len(A)
        # for i in range(1,N):
        #     cur = A[i] + max(0,cur)
        #     ans = max(ans,cur)

        # leftsums = [A[0] for _ in range(N)]
        # for i in range(1,N): leftsums[i] = leftsums[i-1] + A[i]

        # rightsums = [A[-1] for _ in range(N)]
        # maxright = [A[-1] for _ in range(N)]
        # for i in range(N-2,-1,-1):
        #     rightsums[i] = rightsums[i+1] + A[i]
        #     maxright[i] = max(maxright[i+1],rightsums[i])

        # for i in range(1,N-1):
        #     ans = max(ans, leftsums[i-1]+maxright[i])

        # return ans

        
        # method 3
        # def kadane(gen):
        #     if len(gen) == 0: return 0
        #     ans = cur = gen[0]
        #     for i in gen[1:]:
        #         cur = i + max(cur,0)
        #         ans = max(ans,cur)
        #     return ans

        # alls = sum(A)
        # ans1 = kadane(A)
        # ans2 = alls + kadane([-A[i] for i in range(1,len(A)-1)])
        # print(alls,ans1,ans2)
        # return max(ans1,ans2)

        # method 3 improved version
        x = max(A)
        if x < 0:
            return x
        # original A
        ans1 = 0  # solution with end in current item
        ans2 = 0
        cir = 0  # circular A
        org = 0  # current best solution
        Sum = 0
        for a in A:
            ans1 = a + max(0, ans1)
            ans2 = -a + max(0, ans2)
            org = max(ans1, org)
            cir = max(ans2, cir)
            Sum += a
        cir = Sum + cir
        # org = kadane(A)  # max in A, not circular
        # cir = sum(A) + kadane([-a for a in A]) 
        return max(cir, org)
# @lc code=end

