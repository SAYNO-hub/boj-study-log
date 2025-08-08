import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] routes;
    static int[] distances;

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());

        initRoutes(cityCount);
        distances = new int[cityCount + 1];
        Arrays.fill(distances, INF);

        for (int i = 0; i < busCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            routes[from].add(new Node(to, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        printCosts(end);
    }

    private static void initRoutes(int cityCount) {
        routes = new ArrayList[cityCount + 1];
        for (int i = 0; i <= cityCount; i++) {
            routes[i] = new ArrayList<>();
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distances[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;

            if (current.weight > distances[currentVertex])
                continue;

            for (Node neighbor : routes[currentVertex]) {
                int newCost = distances[currentVertex] + neighbor.weight;

                if (newCost < distances[neighbor.vertex]) {
                    distances[neighbor.vertex] = newCost;
                    pq.offer(new Node(neighbor.vertex, newCost));
                }
            }
        }
    }

    private static void printCosts(int end) {
        System.out.println(distances[end]);
    }
}
