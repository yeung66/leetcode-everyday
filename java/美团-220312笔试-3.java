import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        nums = new int[m+1];
        guests = new int[n][2];

        for (int i=0;i<n;i++) {
            guests[i][0] = scanner.nextInt();
            guests[i][1] = scanner.nextInt();
        }

        ans = 0;
        dfs(0, 0);
        System.out.println(ans);
        
    }

    static int n;
    static int m;
    static int[] nums;
    static int[][] guests;
    static int ans;

    public static void dfs(int idx, int cnt) {
        if (idx == n) {
            ans = Math.max(ans, cnt);
            return;
        }

        if (nums[guests[idx][0]] == 0 && nums[guests[idx][1]] == 0) {
            nums[guests[idx][0]] = 1;
            nums[guests[idx][1]] = 1;
            dfs(idx+1, cnt+1);
            nums[guests[idx][0]] = 0;
            nums[guests[idx][1]] = 0;
        }

        dfs(idx+1, cnt);
    }
}