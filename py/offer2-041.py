# https://leetcode.cn/problems/qIsx9U/submissions/

class MovingAverage:

    def __init__(self, size: int):
        """
        Initialize your data structure here.
        """
        self.window = []
        self.size = size
        self.sum = 0


    def next(self, val: int) -> float:
        self.window.append(val)
        self.sum += val
        if len(self.window) > self.size:
            self.sum -= self.window[0]
            self.window = self.window[1:]

        return self.sum / len(self.window)


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)