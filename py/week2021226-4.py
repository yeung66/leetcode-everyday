class Solution:
    cache = {}

    def recoverArray(self, nums: List[int]) -> List[int]:
        nums = sorted(nums)
        n  = len(nums)
        self.cache = {}

        for i in range(n):
            for j in range(i + 1, n):
                if (nums[j] - nums[i]) % 2 == 0:
                    k = (nums[j] - nums[i]) // 2
                    if k > 0:
                        ans = self.check(nums, k)
                        if ans:
                        # print(nums, k)
                            return ans

        return []

    def check(self, nums, k):
        if k in self.cache:
            return self.cache[k]

        i, j = 0, 1
        n = len(nums)
        used = [False for _ in range(n)]
        ans = []
        while i < n  and j < n:
            if used[i]:
                i += 1
                continue

            while j < n and nums[j] - nums[i] != k * 2:
                j += 1

            if j == n:
                return False

            used[i], used[j] = True, True
            ans.append(nums[i] + k)
            i += 1
            j += 1

        self.cache[k] = all(used)
        return self.cache[k] if not self.cache[k] else ans
