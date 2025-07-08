import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static int count = 0; // 경우의 수 : 합이 S가 되는 부분 수열의 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력: N = 수열 크기, S = 목표 합
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 부분 수열 탐색 시작 (현재 인덱스 0, 누적 합 0)
        dfs(0, 0);

        // 공집합도 누적합 0으로 포함되므로, S==0이면 공집합 제외
        // -> 1개 빼야 함
        if (S == 0) count--;

        System.out.println(count);
    }

    /**
     * DFS를 통해 모든 부분 수열의 합을 탐색
     * @param idx  현재 인덱스
     * @param sum  지금까지 선택한 수의 합
     */

    static void dfs(int idx, int sum) {
        // 모든 요소를 다 탐색했을 때
        if (idx == N) {
            if (sum == S) count++; // 합이 S일 경우 경우의 수 +1
            return;
        }

        // 현재 원소를 포함하는 경우
        dfs(idx + 1, sum + arr[idx]);

        // 현재 원소를 포함하지 않는 경우
        dfs(idx + 1, sum);
    }
}
