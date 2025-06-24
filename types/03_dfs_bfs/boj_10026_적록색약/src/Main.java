import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int picSize;
    static char[][] picture;
    static boolean[][] visited;

    // 왼 > 오 > 위 > 아래
    static final int[] dx = {0, 0, -1, +1};
    static final int[] dy = {-1, +1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        picSize = Integer.parseInt(br.readLine());

        picture = new char[picSize][picSize];
        for (int i = 0; i < picSize; i++) {
            picture[i] = br.readLine().toCharArray();            
        }

        int normalCount = countRegions(false);
        int blindCount = countRegions(true);

        System.out.println(normalCount + " " + blindCount);
    }

    private static int countRegions(boolean isColorBlind) {
        visited = new boolean[picSize][picSize];
        int regionCount = 0;

        for (int i = 0; i < picSize; i++) {
            for (int j = 0; j < picSize; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, picture[i][j], isColorBlind);
                    regionCount++;   
                }
            }
        }
        return regionCount;
    }

    private static void bfs(int x, int y, char baseColor, boolean isColorBlind) {
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

                if (nx < 0 || ny < 0 || nx >= picSize || ny >= picSize)
                    continue;
                if (visited[nx][ny]) 
                    continue;

                if (isSameColor(baseColor, picture[nx][ny], isColorBlind)) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean isSameColor(char a, char b, boolean isColorBlind) {
        if (isColorBlind) {
            if (a == 'B' || b == 'B') return a == b;
            return true; // R-G 동일 취급
        } else {
            return a == b;
        }
    }
}
