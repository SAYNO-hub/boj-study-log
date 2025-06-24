import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M, cabbageCount, wormCount;
    static int[][] field;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, +1, 0, 0}; 


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            cabbageCount = Integer.parseInt(st.nextToken());

            field = new int[N][M];
            visited = new boolean[N][M];
            wormCount = 0;

            for (int i = 0; i < cabbageCount; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                field[x][y] = 1; // 배추 있음 표시
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        findWorms(i, j); // 인접 배추들 모두 방문 처리
                        wormCount++; // 이 그룹에 지렁이 1마리 추가
                    }
                }
            }

            System.out.println(wormCount);
        }
    }
    
    // dfs
    public static void findWorms(int x, int y) {        
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (!visited[nx][ny] && field[nx][ny] == 1) {
                    findWorms(nx, ny); // 연결된 배추로 계속 들어가기!
            }
        }
    }
}
