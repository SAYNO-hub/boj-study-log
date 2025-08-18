import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    static int[] distances;
    static int[] prev; // path tracking

    private static class Node implements Comparable<Node> {
        int index, cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // number of cities
        int m = Integer.parseInt(br.readLine()); // number of buses

        initGraph(n);
        distances = new int[n + 1];
        prev = new int[n + 1];
        Arrays.fill(distances, INF);
        Arrays.fill(prev, -1);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        // 최단 경로 복원
        ArrayList<Integer> path = restorePath(end);

        System.out.println(distances[end]);
        System.out.println(path.size());

        StringBuilder sb = new StringBuilder();
        for (int city : path)
            sb.append(city).append(" ");
        System.out.println(sb.toString().trim()); // trim trailing space
    }

    private static void initGraph(int size) {
        graph = new ArrayList[size + 1];
        for (int i = 0; i <= size; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distances[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > distances[cur.index])
                continue;

            for (Node next : graph[cur.index]) {
                int newCost = next.cost + distances[cur.index];

                if (newCost < distances[next.index]) {
                    distances[next.index] = newCost;
                    pq.offer(new Node(next.index, newCost));
                    prev[next.index] = cur.index; // track path
                }
            }
        }
    }

    private static ArrayList<Integer> restorePath(int end) {
        ArrayList<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}
