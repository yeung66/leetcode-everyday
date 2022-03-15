// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[][] board = new char[8][8];
        List<Queue<Character>> supply = new ArrayList<>();

        for (int i=0;i<8;i++) {
            String row = in.next();
            for (int j=0;j<8;j++) {
                board[i][j] = row.charAt(j);
            }
        }

        for (int i=0;i<8;i++) {
            Queue<Character> queue = new LinkedList<>();
            String temp = in.next();
            for (int j=0;j<8*n;j++) {
                queue.offer(temp.charAt(j));    
            }
            supply.add(queue);
        }

        final int[] dirs = new int[] {-1, 0 ,1, 0, -1};

        for (int i=0;i<n;i++) {
            String[] ops = new String[3];
            ops[0] = in.next();
            ops[1] = in.next();
            ops[2] = in.next();
            int x = Integer.parseInt(ops[0]) - 1, y = Integer.parseInt(ops[1]) -1;
            Queue<Integer> queue = new LinkedList<>();
            int cnt = 1;
            char color = board[x][y] != '*' ? board[x][y]: 'r';
            board[x][y] = '*';
            queue.add(x * 8 + y);
            while (!queue.isEmpty()) {
                int pos = queue.poll();
                int nx = pos / 8, ny = pos % 8;
                for (int j=0;j<4;j++) {
                    int dx = nx + dirs[j], dy = ny + dirs[j+1];
                    if (dx >=0&&dx<8&&dy>=0&&dy<8&&board[dx][dy]==color) {
                        board[dx][dy] = '*';
                        queue.add(dx*8+dy);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);

            if (ops[2].equals("w")) {
                for (int col = 0;col < 8;col++) {
                    int idx = 0;
                    for (int row = 0;row<8;row++) {
                        if (board[row][col] != '*') {
                            board[idx][col] = board[row][col];
                            idx++;
                        }
                    }

                    while (idx < 8) {
                        board[idx][col] = supply.get(col).poll();
                        idx++;
                    }
                }
            } else if (ops[2].equals("s")) {
                for (int col = 0;col < 8;col++) {
                    int idx = 7;
                    for (int row = 7;row>=0;row--) {
                        if (board[row][col] != '*') {
                            board[idx][col] = board[row][col];
                            idx--;
                        }
                    }

                    while (idx >= 0) {
                        board[idx][col] = supply.get(col).poll();
                        idx--;
                    }
                }
            } else if (ops[2].equals("a")) {
                for (int row = 0;row < 8;row++) {
                    int idx = 0;
                    for (int col = 0;col<8;col++) {
                        if (board[row][col] != '*') {
                            board[row][idx] = board[row][col];
                            idx++;
                        }
                    }

                    while (idx < 8) {
                        board[row][idx] = supply.get(row).poll();
                        idx++;
                    }
                }
            } else if (ops[2].equals("d")) {
                for (int row = 0;row < 8;row++) {
                    int idx = 7;
                    for (int col = 7;col>=0;col--) {
                        if (board[row][col] != '*') {
                            board[row][idx] = board[row][col];
                            idx--;
                        }
                    }

                    while (idx >= 0) {
                        board[row][idx] = supply.get(row).poll();
                        idx--;
                    }
                }
            }
        }
    }
}