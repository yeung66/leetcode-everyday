class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        ans = []
        for i in nums:
            inserted = False
            for j in ans:
                if i not in j:
                    j.add(i)
                    inserted = True

                if inserted:
                    break

            if not inserted:
                ans.append(set([i]))

        return [list(i) for i in ans]

                