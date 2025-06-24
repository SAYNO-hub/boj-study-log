import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int boardSize;
    static boolean[][] visited;

    static int[] dx = {-1, -2, -2, -1, +1, +2, +2, +1};
    static int[] dy = {-2, -1, +1, +2, -2, -1, +1, +2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        
        while (T-- > 0) {

            boardSize = Integer.parseInt(br.readLine());
            visited = new boolean[boardSize][boardSize];

            StringTokenizer startInput = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(startInput.nextToken());
            int startY = Integer.parseInt(startInput.nextToken());

            StringTokenizer goalInput = new StringTokenizer(br.readLine());
            int goalX = Integer.parseInt(goalInput.nextToken());
            int goalY = Integer.parseInt(goalInput.nextToken());
        
            int result = bfs(startX, startY, goalX, goalY);
            System.out.println(result);

        }

    }

    private static int bfs(int startX, int startY, int goalX, int goalY) {
        Queue<Point> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.offer(new Point(startX, startY, 0));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == goalX && current.y == goalY) {
                return current.moves;
            }

            for (int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= boardSize || ny >= boardSize)
                    continue;

                if (visited[nx][ny])
                    continue;

                visited[nx][ny] = true;
                queue.offer(new Point(nx, ny, current.moves + 1));
            }   
        }
        return -1;
    }

    private static class Point {
        int x, y, moves;

        Point(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }
}
