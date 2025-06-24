import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
// import java.util.LinkedList;
import java.util.List;
// import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int computerCount, connectionCount;
    static List<Integer>[] network;
    static boolean[] visited;
    static int infectedCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerCount = Integer.parseInt(br.readLine());
        connectionCount = Integer.parseInt(br.readLine());

        network = new ArrayList[computerCount + 1];
        for (int i = 1; i <= computerCount; i++) {
            network[i] = new ArrayList<>();
        }


        for (int i = 0; i < connectionCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            network[from].add(to);
            network[to].add(from); // 양방향 연결
        }

        visited = new boolean[computerCount + 1];
        dfs(1);
        // infectedCount = bfs(1);
        System.out.println(infectedCount);
    }

    private static void dfs(int current) {
        visited[current] = true;

        for (int neighbor : network[current]) {
            if (!visited[neighbor]) {
                infectedCount++;
                dfs(neighbor);
            }
        }
    }
}

//     private static int bfs(int start) {
//         Queue<Integer> queue = new LinkedList<>();
//         queue.offer(start);
//         visited[start] = true;

//         int infected = 0;

//         while (!queue.isEmpty()) {
//             int current = queue.poll();

//             for (int neighbor : network[current]) {
//                 if (!visited[neighbor]) {
//                     visited[neighbor] = true;
//                     infected++;
//                     queue.offer(neighbor);
//                 }
//             }
//         }

//         return infected;
//     }
// }
