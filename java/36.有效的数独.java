import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 *
 * https://leetcode-cn.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (62.82%)
 * Likes:    599
 * Dislikes: 0
 * Total Accepted:    180.3K
 * Total Submissions: 285.5K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 
 * 
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 
 * 
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 
 * 注意：
 * 
 * 
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：board = 
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：board = 
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在,
 * 因此这个数独是无效的。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // for (var i = 0; i < 9; i++) {
        //     int finalI = i;
        //     var stream = new String(board[i]).chars().mapToObj(c -> (char) c);
        //     var nums = stream.filter(x -> !x.equals('.')).collect(Collectors.toList());
        //     if (nums.size()!=nums.stream().distinct().count())
        //         return false;

        //     stream = IntStream.range(0, 9).mapToObj(j->board[j][finalI]);
        //      nums = stream.filter(x -> !x.equals('.')).collect(Collectors.toList());
        //     if (nums.size()!=nums.stream().distinct().count())
        //         return false;

        //     int row = i / 3 * 3, col = i % 3 * 3;
        //     stream = IntStream.range(0, 3).mapToObj(x->x).flatMap(r->Stream.of(board[row+r][col],board[row+r][col+1],board[row+r][col+2]));
        //      nums = stream.filter(x -> !x.equals('.')).collect(Collectors.toList());
        //     if (nums.size()!=nums.stream().distinct().count())
        //         return false;
        // }
        
        // return true;


       int length = board.length;
       int[] row = new int[length];
       int[] column = new int[length];
       int[] cell = new int[length];
       for(int i = 0; i < length; i++) {
           for(int j = 0; j < board[i].length; j++) {
               //如果还没有填数字，直接跳过
                if (board[i][j] == '.')
                    continue;
               int value = board[i][j] - '0' - 1;
               int shift = 1 << value;
               int k = i/3*3 + j/3;
               if((row[i] & shift) != 0 || (column[j] & shift) != 0 || (cell[k] & shift) != 0) {
                   return false;
               }
               row[i] |= shift;
               column[j] |= shift;
               cell[k] |= shift;
           }
       }
       return true;
   
    }
}
// @lc code=end

