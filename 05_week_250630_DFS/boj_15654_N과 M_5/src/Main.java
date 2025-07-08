import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;      // 주어진 숫자들
    static int[] output;   // 현재 순열을 담을 배열
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder(); // 정답 출력

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        output  = new int[M];
        visited = new boolean[N];

        dfs(0);
        System.out.print(sb.toString());
    }

    // depth: 현재까지 선택한 원소 개수 > 총 M개가 되어야 함.
    static void dfs(int depth) {
        if (depth == M) {               // M개를 모두 골랐다면
            for (int i = 0; i < M; i++) sb.append(output[i]).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {   // 순서 유지를 위해 0 -> N‑1 
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                dfs(depth + 1);         // 다음 원소 고르기
                visited[i] = false;     // 선택 취소 = 백트래킹 (dfs(depth + 1) 호출이 끝나고 돌아오면, 그 선택은 끝났으므로 다시 원상복구)
            }
        }
    }
}
