import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] maze;
    static int[][] dp;

    static int[] dx = {+1, 0, +1};
    static int[] dy = {0, +1, +1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N+1][M+1];
        dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = maze[i][j] + max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);
            }
        }
        System.out.println(dp[N][M]);
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
