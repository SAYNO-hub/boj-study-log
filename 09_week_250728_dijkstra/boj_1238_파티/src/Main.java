import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE / 2;
    static int cityCount, roadCount, partyCity;

    static ArrayList<Edge>[] graph;
    static ArrayList<Edge>[] reverseGraph;

    private static class Edge implements Comparable<Edge> {
        int pos, time;

        Edge(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cityCount = Integer.parseInt(st.nextToken());
        roadCount = Integer.parseInt(st.nextToken());
        partyCity = Integer.parseInt(st.nextToken());

        initGraph(cityCount);

        for (int i = 0; i < roadCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, time)); // 원래 그래프
            reverseGraph[to].add(new Edge(from, time)); // 역방향 그래프
        }

        int[] distancesFromParty = dijkstra(partyCity, graph);
        int[] distancesToParty = dijkstra(partyCity, reverseGraph);

        int maxTime = 0;
        for (int i = 1; i <= cityCount; i++) {
            if (distancesFromParty[i] == INF || distancesToParty[i] == INF) {
                continue;
            }
            maxTime = Math.max(maxTime, distancesFromParty[i] + distancesToParty[i]);
        }
        System.out.println(maxTime);
    }

    private static void initGraph(int size) {
        graph = new ArrayList[size + 1];
        reverseGraph = new ArrayList[size + 1];
        for (int i = 0; i <= size; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
    }

    private static int[] dijkstra(int start, ArrayList<Edge>[] graph) {
        int[] distances = new int[cityCount + 1];
        Arrays.fill(distances, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distances[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int curPos = current.pos;
            int curTime = current.time;

            if (distances[curPos] < curTime) {
                continue;
            }

            for (Edge neighbor : graph[curPos]) {
                int nextTime = curTime + neighbor.time;

                if (nextTime < distances[neighbor.pos]) {
                    distances[neighbor.pos] = nextTime;
                    pq.offer(new Edge(neighbor.pos, nextTime));
                }
            }
        }
        return distances;
    }
}
