import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++) {
            nums[i] = scanner.nextInt();
        }

        int[] plus = new int[n], neg = new int[n];
        plus[0] = nums[0] == 1 ? 1 : 0;
        neg[0] = nums[0] == -1 ? 1 : 0;
        int ans = plus[0];
        for (int i=1;i<n;i++) {
            if (nums[i] == 1) {
                plus[i] = plus[i-1] + 1;
                neg[i] = neg[i-1];
            } else {
                plus[i] = neg[i-1];
                neg[i] = plus[i-1] + 1;
            }
            ans += plus[i];
        }

        System.out.println(ans);
    }
}