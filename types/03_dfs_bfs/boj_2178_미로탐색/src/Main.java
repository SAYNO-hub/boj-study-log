import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    // left, right, up, down 좌표
    static int[] dx = {0, 0, -1, 1}; // x좌표 이동
    static int[] dy = {-1, +1, 0, 0}; // y좌표 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine(); // 문자열의 index는 0부터 시작
            for (int j = 1; j <= M; j++) {
                maze[i][j] = line.charAt(j-1) - '0'; 
            }
        }

        visited[1][1] = true;
        escape(1, 1);
        System.out.println(maze[N][M]);
    }

    public static void escape(int x, int y) {
        Queue<Spot> queue = new LinkedList<>();
        queue.offer(new Spot(x, y));

        while (!queue.isEmpty()) {
            Spot curSpot = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curSpot.x + dx[i];
                int nextY = curSpot.y + dy[i];
                
                if (nextX < 1 || nextY < 1 || nextX > N || nextY > M) continue;
                if (visited[nextX][nextY] || maze[nextX][nextY] == 0) continue;
                
                queue.offer(new Spot(nextX, nextY));
                maze[nextX][nextY] = maze[curSpot.x][curSpot.y] + 1;
                visited[nextX][nextY] = true;
            }
		}
    }

    public static class Spot {
        int x, y;
        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}