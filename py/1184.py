class Solution:
    def distanceBetweenBusStops(self, distance: List[int], start: int, destination: int) -> int:
        dis1 = dis2 = 0
        if destination < start:
            start, destination = destination, start

        for i in range(start, destination):
            dis1 += distance[i]

        for i in range(destination, len(distance)):
            dis2 += distance[i]

        for i in range(0, start):
            dis2 += distance[i]

        return dis1 if dis1 < dis2 else dis2