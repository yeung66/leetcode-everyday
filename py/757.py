from typing import List

class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x:x[0], reverse=True)
        intersection_set = []
        for s, e in intervals:
            if len(intersection_set) == 0:
                intersection_set = [s, s+1]
            else:
                cnt = 0
                for i in intersection_set:
                    if s <= i <= e:
                        cnt += 1
                        if cnt >= 2:
                            break

                if cnt < 2:
                    intersection_set = list(range(s, s+2-cnt)) + intersection_set

        return len(intersection_set)


