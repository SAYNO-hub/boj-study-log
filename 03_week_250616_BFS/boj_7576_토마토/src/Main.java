import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int rows, cols;
    static int[][] box;

    // 왼 > 오 > 위 > 아래
    static int[] dx = {0, 0, -1, +1};
    static int[] dy = {-1, +1, 0, 0};

    static final int TOMATO_EMPTY = -1;
    static final int TOMATO_UNRIPE = 0;
    static final int TOMATO_RIPE = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cols = Integer.parseInt(st.nextToken());
        rows = Integer.parseInt(st.nextToken());
        
        box = new int[rows][cols];
        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < cols; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == TOMATO_RIPE) {
                    queue.offer(new Tomato(i, j, 0));
                }
            }
        }

        int days = bfs(queue);

        // 안 익은 토마토 확인
        for (int[] row : box) {                
            for (int tomato : row) {
                if (tomato == TOMATO_UNRIPE) {
                    System.out.println(-1);
                    return;
                }  
            }
        }

        System.out.println(days);
    }

    private static int bfs(Queue<Tomato> queue) {
        int maxDays = 0;

        while (!queue.isEmpty()) {
            Tomato t = queue.poll();
            maxDays = t.days;

            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= rows || ny >= cols)
                    continue;
                if (box[nx][ny] != TOMATO_UNRIPE) 
                    continue;

                box[nx][ny] = TOMATO_RIPE;
                queue.offer(new Tomato(nx, ny, t.days + 1));
            }  
        }
        
        return maxDays; // 모든 토마토가 익어있는 상태 : 0 리턴  
    }

    private static class Tomato {
        int x, y, days;

        Tomato(int x, int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }
    }
}
