
def distance(p1, p2):
    return ((p1[0] - p2[0]) ** 2 + (p1[1]-p2[1])**2) ** (.5)


class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        dis = [distance(p1, p2)
        , distance(p1, p3)
        , distance(p1, p4)
        , distance(p2, p3)
        , distance(p2, p4)
        , distance(p3, p4)]
        dis.sort()
        return len(set(dis[:4])) == 1 and len(set(dis[4:])) == 1 and len(set(dis)) == 2
