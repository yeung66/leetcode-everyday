import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i=0;i<n;i++) {
            long query = scanner.nextLong();
            if (query % 11 == 0) {
                System.out.println("yes");
            } else {
                long temp = query;
                int cnt = 0;
                while (temp > 0) {
                    if (temp % 10 == 1) {
                        cnt++;
                    }
                    temp /= 10;
                }

                if (cnt >= 2) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}