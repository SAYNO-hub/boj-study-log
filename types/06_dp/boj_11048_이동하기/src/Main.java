import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        /* ➊ 메모리 절약용 ― 직전 행만 보관 */
            int[] prev = new int[M + 1];
            int[] curr = new int[M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int candy = Integer.parseInt(st.nextToken());
                
                /* 점화식: 왼쪽·위·대각선 중 최댓값 + 현재 사탕 */
                curr[j] = candy + Math.max(prev[j],  Math.max(curr[j - 1], prev[j - 1]));
            }
            /* ➋ 다음 행 계산을 위해 스와프 */
            int[] tmp = prev;
            prev = curr;
            curr = tmp;  // curr 배열은 재사용 (값 초기화)
        }

        System.out.println(prev[M]);
    }
}
