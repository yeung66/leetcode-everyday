import java.util.*;

public class Main {
    static int[] colors;
    static List<List<Integer>> children;

    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        colors = new int[n+1];
        int[] parents = new int[n+1];
        int root = 1;
        for (int i=1;i<=n;i++) {
            colors[i] = scanner.nextInt();
        }

        for (int i=1;i<=n;i++) {
            parents[i] = scanner.nextInt();
        }

        children = new ArrayList<>();
        for (int i=0;i<=n;i++) {
            children.add(new ArrayList<>());
        }

        for (int i=1;i<=n;i++) {
            if (parents[i] != 0) children.get(parents[i]).add(i);
        }

        int black = 0, white = 0;
        for (int i=1;i<=n;i++) {
            if (colors[i] == 0) {
                if (children.get(i).size() == 0) white++;
                else {
                    for (var c:children.get(i)) {
                        if (colors[c] == 1) {
                            white++;
                            break;
                        }
                    }
                }
            } else {
                if (children.get(i).size() == 0) black++;
                else {
                    boolean isGood = true;
                    for (var c:children.get(i)) {
                        if (colors[c] == 1) {
                            isGood = false;
                            break;
                        }
                    }

                    if (isGood) black++;
                }
            }
        }

        System.out.printf("%d %d\n", white, black);
    }
}