import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;

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

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        initGraph(nodeCount);

        for (int i = 0; i < edgeCount; i++) {
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

        long route1 = 0;
        route1 += dijkstra(1, v1, nodeCount);
        route1 += dijkstra(v1, v2, nodeCount);
        route1 += dijkstra(v2, nodeCount, nodeCount);

        long route2 = 0;
        route2 += dijkstra(1, v2, nodeCount);
        route2 += dijkstra(v2, v1, nodeCount);
        route2 += dijkstra(v1, nodeCount, nodeCount);

        long answer = Math.min(route1, route2);
        if (answer >= INF)
            answer = -1;
        System.out.println(answer);
    }

    private static void initGraph(int size) {
        graph = new ArrayList[size + 1];
        for (int i = 0; i <= size; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    private static int dijkstra(int start, int end, int N) {
        int[] dist = new int[N + 1];
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
