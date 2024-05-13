class Solution:
    def minimumRefill(self, plants: List[int], capacityA: int, capacityB: int) -> int:
        times = 0
        restA, restB = capacityA, capacityB
        idxA, idxB = 0, len(plants) - 1
        while idxA < idxB:
            if restA >= plants[idxA]:
                restA -= plants[idxA]
            else:
                restA = capacityA - plants[idxA]
                times += 1

            idxA += 1

            if restB >= plants[idxB]:
                restB -= plants[idxB]
            else:
                restB = capacityB - plants[idxB]
                times += 1

            idxB -= 1

        if idxA == idxB and (max(restA, restB) < plants[idxA]):
            times += 1

        return times
