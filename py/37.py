class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        
        rows = [[False] * 9 for _ in range(9)]
        cols = [[False] * 9 for _ in range(9)]
        blocks = [[False] * 9 for _ in range(9)]
        spaces = list()
        valid = False

        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    spaces.append((i, j))
                else:
                    digit = int(board[i][j]) - 1
                    rows[i][digit] = True
                    cols[j][digit] = True
                    blocks[(i // 3) * 3 + j // 3][digit] = True
        
        def solve(pos):
            nonlocal valid
            if pos == len(spaces):
                valid = True
                return
            
            i, j = spaces[pos]
            for digit in range(9):
                if rows[i][digit] == cols[j][digit] == blocks[(i // 3) * 3 + j // 3][digit] == False:
                    rows[i][digit] = cols[j][digit] = blocks[(i // 3) * 3 + j // 3][digit] = True
                    board[i][j] = str(digit + 1)

                    solve(pos + 1)
                    
                    rows[i][digit] = cols[j][digit] = blocks[(i // 3) * 3 + j // 3][digit] = False
                    
                    if valid:
                        return
                    
        solve(0)
