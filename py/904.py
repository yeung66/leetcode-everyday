class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        cnt = Counter()
        
        left = ans = 0
        for right, f in enumerate(fruits):
            cnt[fruits[right]] += 1
            while len(cnt) > 2:
                cnt[fruits[left]] -= 1
                if cnt[fruits[left]] == 0:
                    cnt.pop(fruits[left])

                left += 1

            ans = max(ans, right - left + 1)
        
        return ans


