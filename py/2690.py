class Solution:
    def countTestedDevices(self, batteryPercentages: List[int]) -> int:
        tested, minus = 0, 0
        for idx in range(0, len(batteryPercentages)):
            if batteryPercentages[idx] > minus:
                tested += 1
                minus += 1
            
        return tested