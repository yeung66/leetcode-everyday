class Solution:
    def checkDistances(self, s: str, distance: List[int]) -> bool:
        alpha = 'abcdefghijklmnopqrstuvwxyz'
        for i, d in enumerate(distance):
            a = alpha[i]
            if a not in s:
                continue
            
            lidx = s.index(a)
            ridx = s.rindex(a)
            if ridx - lidx - 1 != d:
                return False
            

        return True