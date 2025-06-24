import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        final int MAX_N = 10; // 문제에서 1 ≤ n ≤ 10이 주어짐

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dp = computeDP(MAX_N + 1);

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);
    }

    private static int[] computeDP(int max) {
        int[] dp = new int[max];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < max; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        return dp;
    }
}
