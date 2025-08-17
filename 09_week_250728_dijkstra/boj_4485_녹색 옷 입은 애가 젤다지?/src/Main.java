import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    // 상하좌우 이동 좌표
    // (기존)
    // static private int[] dx = { 0, 0, -1, +1 };
    // static private int[] dy = { -1, +1, 0, 0 };

    // (new)
    private static final int[][] DIRECTIONS = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    // 큐에서 사용할 노드 클래스 (좌표 + 현재까지 비용)
    private static class Node implements Comparable<Node> {
        int x, y, cost;

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
        int problemNo = 1;
        String input;

        // 0이 입력될 때까지 여러 케이스 처리
        while (!(input = br.readLine()).equals("0")) {
            int N = Integer.parseInt(input);
            int[][] cave = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = dijkstra(cave, N);

            // 기존
            // sb.append("Problem ").append(th).append(": ")
            // .append(costs[N - 1][N - 1]).append("\n");
            // th++;

            // 결과 저장
            sb.append("Problem ").append(problemNo++)
                    .append(": ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    // 다익스트라 알고리즘을 메서드로 분리
    private static int dijkstra(int[][] cave, int N) {
        // 각 칸까지 최소 비용 저장 -> 최소 비용 비교니까 MAX로 초기화
        int[][] costs = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(costs[i], Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        costs[0][0] = cave[0][0];
        pq.offer(new Node(0, 0, cave[0][0])); // 시작점 큐에 추가

        // 다익스트라 알고리즘
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 이미 더 짧은 경로가 발견된 경우 무시
            if (cur.cost > costs[cur.x][cur.y])
                continue;

            // 상하좌우 이동
            for (int[] dir : DIRECTIONS) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                // 범위 체크
                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                int newCost = cur.cost + cave[nx][ny];

                // 새 경로가 더 짧으면 갱신하고 큐에 추가
                if (newCost < costs[nx][ny]) {
                    costs[nx][ny] = newCost;
                    pq.offer(new Node(nx, ny, newCost));
                }
            }
        }

        return costs[N - 1][N - 1];
    }
}
