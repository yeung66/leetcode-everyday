from dataclasses import dataclass

def gcd(a, b):
    if a < b:
        a, b = b, a
    while b != 0:
        a, b = b, a % b
    return a


@dataclass
class Num:
    up:int
    down:int
    pos:int

    def add(self, other):
        downNew = self.down * other.down
        upNew = self.up * other.down * self.pos + other.up * other.pos * self.down
        if upNew < 0:
            upNew = -upNew
            self.pos = -1
        else:
            self.pos = 1

        reduce = gcd(downNew, upNew)
        self.up = upNew // reduce
        self.down = downNew // reduce

    def __str__(self) -> str:
        base = f'{self.up}/{self.down}'
        if self.pos == -1:
            base = '-' + base
        return base

    

class Solution:
    def fractionAddition(self, expression: str) -> str:
        idx = 0
        nums: Num = []
        while idx < len(expression):
            pos = 1
            start = idx
            if expression[idx] == '-' or expression[idx] == '+':
                pos = -1 if expression[idx] == '-' else 1
                start += 1
                idx += 1
            
            while idx < len(expression) and expression[idx] != '-' and expression[idx] != '+':
                idx += 1

            print(start, idx, expression[start:idx].split('/'))
            up, down = list(map(int, (expression[start:idx].split('/'))))
            print(nums)
            nums.append(Num(up, down, pos))

        num = nums[0]
        for i in nums[1:]:
            num.add(i)

        return str(num)
