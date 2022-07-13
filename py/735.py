# https://leetcode.cn/problems/asteroid-collision/

class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        left = []
        ans = []
        for i in asteroids:
            if i > 0:
                left.append(i)
            else:
                if len(left) == 0:
                    ans.append(i)
                else:
                    equal = False
                    while len(left) > 0 and left[-1] <= abs(i):
                        if left[-1] == abs(i):
                            equal = True
                            break
                        left.pop()

                    if equal:
                        left.pop()
                    elif len(left) == 0:
                        ans.append(i)
                        

        ans.extend(left)

        return ans