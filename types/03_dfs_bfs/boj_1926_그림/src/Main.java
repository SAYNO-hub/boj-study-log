import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int height, width;
    static int[][] picture;
    static boolean[][] visited;
    static int picCount, maxArea;

    // 왼 > 오 > 위 > 아래
    static int[] dx = {0, 0, -1, 1}; // x좌표 이동, 행 방향 (x) = 위/아래
    static int[] dy = {-1, 1, 0, 0}; // y좌표 이동, 열 방향 (y) = 좌/우

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer initialInput = new StringTokenizer(br.readLine());
        
        height = Integer.parseInt(initialInput.nextToken());
        width = Integer.parseInt(initialInput.nextToken());

        picture = new int[height][width];
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            StringTokenizer picInput = new StringTokenizer(br.readLine());

            for (int j = 0; j < width; j++) {
                picture[i][j] = Integer.parseInt(picInput.nextToken());
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (picture[i][j] == 1 && !visited[i][j]) {
                    int area = bfs(i, j);
                    maxArea = Math.max(maxArea, area);
                    picCount++;
                }
            }
        }

    System.out.println(picCount);
    System.out.println(maxArea);  
    }

    private static int bfs(int x, int y) {
        Queue<Spot> queue = new LinkedList<>();
        queue.offer(new Spot(x, y));
        visited[x][y] = true;
        int area = 1;

        while (!queue.isEmpty()) {
            Spot curSpot = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = curSpot.x + dx[i];
                int ny = curSpot.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= height || ny >= width) 
                    continue;
                if (visited[nx][ny] || picture[nx][ny] == 0) 
                    continue;
                
                queue.offer(new Spot(nx, ny));
                visited[nx][ny] = true;
                area++;
            }

        }

        return area;
    }

    private static class Spot {
        int x, y = 0;
        
        private Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
