// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.next();
        long cnt = 0;
        for (char c:num.substring(2).toCharArray()) {
            if (c == '1' || c == '2' || c == '4' || c == '8') cnt++;
            else if (c == '3' || c == '6' || c == 'c' || c == '5' || c == '9' || c == 'a') cnt += 2;
            else if (c == '7' || c == 'e' || c == 'd' || c == 'b') cnt += 3;
            else if (c == 'f') cnt += 4;
        }

        System.out.println(cnt);
    }
}