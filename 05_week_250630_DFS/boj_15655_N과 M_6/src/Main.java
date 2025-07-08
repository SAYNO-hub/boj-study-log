import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;      // 주어진 숫자들
    static int[] output;   // 현재 순열을 담을 배열
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
        dfs(0, 0); // 시작 인덱스 = 0
        System.out.print(sb.toString());
    }

    // depth: 현재까지 선택한 원소 개수 > 총 M개가 되어야 함. 
    // start: 현재 검색 시작 위치 인덱스 저장
    static void dfs(int depth, int start) {
        if (depth == M) {               // M개를 모두 골랐다면
            for (int i = 0; i < M; i++) sb.append(output[i]).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            output[depth] = arr[i];
            dfs(depth + 1, i + 1);  // 조합: 다음엔 i+1부터
        }
    }
}