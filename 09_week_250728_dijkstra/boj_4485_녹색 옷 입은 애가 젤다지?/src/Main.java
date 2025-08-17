import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    // 상하좌우
    static private int[] dx = { 0, 0, -1, +1 };
    static private int[] dy = { -1, +1, 0, 0 };

    private static class Node implements Comparable<Node> {
        int x, y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int th = 1;
        String input;

        while (!(input = br.readLine()).equals("0")) {

            int N = Integer.parseInt(input);

            int[][] cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            int[][] costs = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(costs[i], Integer.MAX_VALUE);
            }
            costs[0][0] = cave[0][0];
            pq.offer(new Node(0, 0, cave[0][0]));

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                int curX = current.x;
                int curY = current.y;
                int curCost = current.cost;

                // 이미 더 짧은 경로가 발견된 경우 skip
                if (curCost > costs[curX][curY]) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = curX + dx[i];
                    int nextY = curY + dy[i];

                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                        continue;
                    }

                    int newCost = curCost + cave[nextX][nextY];
                    if (newCost < costs[nextX][nextY]) {
                        costs[nextX][nextY] = newCost;
                        pq.offer(new Node(nextX, nextY, newCost));
                    }
                }
            }

            sb.append("Problem ").append(th).append(": ")
                    .append(costs[N - 1][N - 1]).append("\n");
            th++;
        }

        System.out.println(sb);
    }
}
