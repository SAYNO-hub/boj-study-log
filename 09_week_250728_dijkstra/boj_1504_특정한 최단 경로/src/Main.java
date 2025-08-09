import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int INF = 200_000_000; // 오버플로 방지
    private static List<Node>[] graph;

    static private class Node implements Comparable<Node> {
        int vertex, cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(cost, other.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        initGraph(n);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long route1 = calcRoute(1, v1, v2, n);
        long route2 = calcRoute(1, v2, v1, n);

        long answer = Math.min(route1, route2);
        System.out.println(answer >= INF ? -1 : answer);
    }

    /** 그래프 초기화 */
    private static void initGraph(int size) {
        graph = new ArrayList[size + 1];
        for (int i = 0; i <= size; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    /** 특정 경로의 거리 합 계산 */
    private static long calcRoute(int start, int mid1, int mid2, int n) {
        long dist1 = dijkstra(start, mid1, n);
        long dist2 = dijkstra(mid1, mid2, n);
        long dist3 = dijkstra(mid2, n, n);

        // 중간에 하나라도 도달 불가능이면 INF 반환
        if (dist1 >= INF || dist2 >= INF || dist3 >= INF)
            return INF;
        return dist1 + dist2 + dist3;
    }

    /** 다익스트라 알고리즘 */
    private static int dijkstra(int start, int end, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.vertex])
                continue;

            for (Node next : graph[cur.vertex]) {
                int newCost = dist[cur.vertex] + next.cost;
                if (newCost < dist[next.vertex]) {
                    dist[next.vertex] = newCost;
                    pq.offer(new Node(next.vertex, newCost));
                }
            }
        }
        return dist[end];
    }
}
