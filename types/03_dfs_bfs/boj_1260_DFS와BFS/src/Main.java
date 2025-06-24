import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static boolean[][] adjacent; 
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점 수
        M = Integer.parseInt(st.nextToken()); // 간선 수
        V = Integer.parseInt(st.nextToken()); // 시작 정점

        adjacent = new boolean[N+1][N+1]; 
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjacent[x][y] = adjacent[y][x] = true; // 양방향 연결 
        }

        dfs(V);
        sb.append("\n");

        // Arrays.fill(visited,false); 이 더 비효율적 (GC 제외)
        // 이미 만들어진 배열을 반복문으로 한칸씩 직접 채움
        visited = new boolean[N+1];

        bfs();
        System.out.println(sb);
    }

    public static void dfs(int i) {
        visited[i] = true;
        sb.append(i + " ");
        for (int j = 1; j <= N; j++) {
            if (adjacent[i][j] && !visited[j]) {
                dfs(j); // 연결된 정점 중 방문 안 한 곳 재귀 호출
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp + " ");

            for (int j = 1; j <= N; j++) {
                if (adjacent[temp][j] && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                } 
            }
        }
    }
}

