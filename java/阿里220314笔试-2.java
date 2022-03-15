// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        int[][] board = new int[m+1][n+1];
        int[][] left = new int[m+1][n+1];
        int[][] top = new int[m+1][n+1];

        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                board[i][j] = in.nextInt();
            }
        }

        for (int i=1;i<=m;i++) {
            int have = 0;
            for (int j=1;j<=n;j++) {
                if (board[i][j] == 1) have += 1;
                left[i][j] = have;
            }
        }

        for (int i=1;i<=n;i++) {
            int have = 0;
            for (int j=1;j<=m;j++) {
                if (board[j][i] == 1) have += 1;
                top[j][i] = have;
            }
        }

        long ans = 0;
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (board[i][j] == 0) {
                    if (left[i][j] > 0) ans++;
                    if (left[i][n] - left[i][j] > 0) ans++;
                    if (top[i][j] > 0) ans++;
                    if (top[m][j] - top[i][j] > 0) ans++;
                }
            }
        }

        System.out.println(ans);
    }
}