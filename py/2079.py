class Solution:
    def wateringPlants(self, plants: List[int], capacity: int) -> int:
        steps, water = 0, capacity
        for i, cur in enumerate(plants):
            if water >= cur:
                steps += 1
                water -= cur
            else:
                steps += 2 * i + 1
                water = capacity - cur

        return steps