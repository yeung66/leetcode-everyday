class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        l, r = 0, k + 1
        window = set(nums[:r])

        if len(window) < min(k+1, len(nums)):
            return True

        while r < len(nums):
            window.remove(nums[l])

            if nums[r] in window:
                return True

            window.add(nums[r])
            r += 1
            l += 1

        return False
            

