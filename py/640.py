import re

class Solution:
    def solveEquation(self, equation: str) -> str:
        left, right = equation.split('=')
        var = const = 0
        tokens = re.findall('[\+-]?\d*x?', left)
        # print(tokens, left)
        for i in tokens:
            if i:
                if 'x' in i:
                    var += int(i[:-1]) if i not in ('x', '+x', '-x') else (-1 if i == '-x' else 1)
                else:
                    const += int(i)

        tokens = re.findall('[\+-]?\d*x?', right)
        for i in tokens:
            if i:
                if 'x' in i:
                    var -= int(i[:-1]) if i not in ('x', '+x', '-x') else (-1 if i == '-x' else 1)
                else:
                    const -= int(i)
        # print(var, const)

        if var == 0:
            return "Infinite solutions" if const == 0 else "No solution"

        return f'x={const // (-var)}'


        
