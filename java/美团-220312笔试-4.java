import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] bombs = new int[m+1];

        for (int i=1;i<=m;i++) {
            bombs[i] = scanner.nextInt();
        }

        int[][] dp = new int[m+1][n+1];
        for (var row: dp) {
            Arrays.fill(row, m);
        }

        for (int i=2;i<=n;i++) {
            dp[1][i] = -1;
        }

        dp[1][1] = 0;

        for (int i=2;i<=m;i++) {
            
            for (int j=1;j<=n;j++) {
                if (bombs[i] == j) {
                    dp[i][j] = -1;
                    continue;
                } 

                for (int k=1;k<=n;k++) {
                    if (dp[i-1][k] == -1) continue;
                    if (j==k) dp[i][j] = Math.min(dp[i][j], dp[i-1][k]);
                    else {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + 1);
                    }
                }

                // System.out.printf("%d %d %d, ", i, j, dp[i][j]);
            }
            // System.out.println();
        }

        int ans = m;
        for (int i=1;i<=n;i++) {
            if (dp[m][i] != -1 && dp[m][i] < ans) ans = dp[m][i];
            // System.out.println(dp[m][i]);
        }

        System.out.println(ans);
        
    }
}