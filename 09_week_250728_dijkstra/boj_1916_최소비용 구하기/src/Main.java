import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Edge>[] graph;
    static int[] distances;

    private static class Edge implements Comparable<Edge> {
        int target;
        int cost;

        Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());

        initGraph(cityCount);
        distances = new int[cityCount + 1];
        Arrays.fill(distances, INF);

        for (int i = 0; i < busCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(distances[end]);
    }

    private static void initGraph(int size) {
        graph = new ArrayList[size + 1];
        for (int i = 0; i <= size; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distances[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.target;

            if (current.cost > distances[currentNode])
                continue;

            for (Edge neighbor : graph[currentNode]) {
                int newCost = distances[currentNode] + neighbor.cost;

                if (newCost < distances[neighbor.target]) {
                    distances[neighbor.target] = newCost;
                    pq.offer(new Edge(neighbor.target, newCost));
                }
            }
        }
    }
}
