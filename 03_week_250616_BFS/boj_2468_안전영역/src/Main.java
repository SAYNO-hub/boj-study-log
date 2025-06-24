import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;

    // 왼 > 오 > 위 > 아래
    static final int[] dx = {0, 0, -1, +1};
    static final int[] dy = {-1, +1, 0, 0}; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int maxSafeZones = 0;

        for (int waterLevel = 0; waterLevel <= maxHeight; waterLevel++) {
            boolean[][] visited = new boolean[N][N];
            int safeZoneCount = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && (map[i][j] > waterLevel)) {
                        bfs(i, j, waterLevel, visited);
                        safeZoneCount++;
                    }
                }
            }
            maxSafeZones = Math.max(maxSafeZones, safeZoneCount);
        }
        
        System.out.println(maxSafeZones);
    }

    private static void bfs(int x, int y, int waterLevel, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) 
                    continue;
                if (visited[nx][ny] || (map[nx][ny] <= waterLevel))
                    continue;
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}
