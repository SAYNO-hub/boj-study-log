import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        final int MAX = 5001;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[MAX];
        Arrays.fill(dp, -1);
        dp[3] = dp[5] = 1;
        
        for(int i = 6; i <= N; i++) {
            int a = dp[i - 3];
            int b = dp[i - 5];

            if(a == -1 && b == -1) dp[i] = -1;
            else if(a == -1) dp[i] = b + 1;
            else if(b == -1) dp[i] = a + 1;
            else dp[i] = Math.min(a, b) + 1;
        }

        System.out.println(dp[N]);
    }
}
