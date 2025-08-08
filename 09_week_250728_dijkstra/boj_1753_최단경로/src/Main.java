import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    static int[] distances;

    static class Node implements Comparable<Node> {
        int vertex; // 목적지 노드 번호
        int weight; // 가중치 (거리)

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }

        @Override
        public String toString() {
            // 디버깅용으로 Node 객체 내용을 쉽게 확인하기 위해 오버라이드
            // 예를 들어, 디버깅 시 PriorityQueue에 들어있는 노드를 출력하면
            // Node(정점번호, 가중치) 형태로 출력되어 상태를 빠르게 파악할 수 있음
            return "(" + vertex + ", " + weight + ")";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexCount = Integer.parseInt(st.nextToken()); // 정점 개수 V
        int edgeCount = Integer.parseInt(st.nextToken()); // 간선 개수 E
        int start = Integer.parseInt(br.readLine()); // 시작 정점의 번호 K

        initGraph(vertexCount);
        distances = new int[vertexCount + 1];
        Arrays.fill(distances, INF);

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
        }

        dijkstra(start);

        printDistances(vertexCount);
    }

    private static void initGraph(int vertexCount) {
        graph = new ArrayList[vertexCount + 1];
        for (int i = 0; i <= vertexCount; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distances[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;

            if (current.weight > distances[currentVertex])
                continue; // 이미 처리된 경우 건너뛰기

            for (Node neighbor : graph[currentVertex]) {
                int newDist = distances[currentVertex] + neighbor.weight;

                if (newDist < distances[neighbor.vertex]) {
                    distances[neighbor.vertex] = newDist;
                    pq.offer(new Node(neighbor.vertex, newDist));
                }
            }
        }
    }

    private static void printDistances(int vertexCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= vertexCount; i++) {
            if (distances[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(distances[i]).append('\n');
            }
        }
        System.out.print(sb);
    }
}
