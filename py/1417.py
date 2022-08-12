class Solution:
    def reformat(self, s: str) -> str:
        nums, chars = [], []
        for i in s:
            if i.isalpha():
                chars.append(i)
            else:
                nums.append(i)

        if abs(len(nums) - len(chars)) > 1:
            return ''

        ans = []
        if len(nums) > len(chars):
            nums, chars = chars, nums

        for i, c in enumerate(nums):
            ans.append(c + chars[i])

        if len(nums) != len(chars) and chars:
            ans.insert(0, chars[-1])

        return ''.join(ans)
