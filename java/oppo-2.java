import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), c = in.nextInt();
        relations = new HashMap<>();
        for (int i=0;i<n;i++) {
            int x = in.nextInt(), y = in.nextInt();
            relations.putIfAbsent(x, new HashSet<>());
            relations.get(x).add(y);
        }

        visited = new HashSet<>();
        visited.add(c);
        dfs(c);
        System.out.println(visited.size());

    }

    static Map<Integer, Set<Integer>> relations;
    static Set<Integer> visited;

    static public void dfs(int start) {
        if (!relations.containsKey(start)) return;
        for (int next:relations.get(start)) {
            if (!visited.contains(next)) {
                visited.add(next);
                dfs(next);
            }
        }
    }
}