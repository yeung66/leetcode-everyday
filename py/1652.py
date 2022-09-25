class Solution:
    def decrypt(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        if k == 0:
            return [0 for _ in range(n)]

        # sums = [sum(nums[(i+j)%n] for j in range(1,k+1)) for i in range(n)] if k > 0 else [sum(nums[(n+i-j)%n] for j in range(1,-k+1)) for i in range(n)]

        sums = [0 for _ in range(n)]
        less = k < 0
        if less:
            nums = nums[::-1]
            k = -k


        sums[0] = sum(nums[1:k+1])
        for i in range(1,n):
            sums[i] = sums[i-1] - nums[i] + nums[(i+k)%n]

        if less:
            sums = sums[::-1]

        return sums
        
            