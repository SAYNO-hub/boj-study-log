import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int mapSize;
    static int[][] map;
    static boolean[][] visited;

    // 왼 > 오 > 위 > 아래
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(br.readLine());

        map = new int[mapSize][mapSize];
        visited = new boolean[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            String mapInput = br.readLine();
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = mapInput.charAt(j) - '0';
            }
        }

        List<Integer> houseCounts = new ArrayList<>();

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    houseCounts.add(bfs(i, j));
                }
            }
        }
        
        Collections.sort(houseCounts);
        System.out.println(houseCounts.size());

        for (int count : houseCounts) {
            System.out.println(count);
        }
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= mapSize || ny >= mapSize)
                    continue;
                if (map[nx][ny] == 0 || visited[nx][ny]) 
                    continue;

                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                count++;
            }
        }

        return count;
    }

}
