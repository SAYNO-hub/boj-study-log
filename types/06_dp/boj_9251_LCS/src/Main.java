import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        int aLen = A.length();
        int bLen = B.length();

        int[][] dp = new int[aLen + 1][bLen + 1];

        for (int i = 0; i < aLen; i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
        }

        for (int i = 1; i <= aLen; i++) {
            char a = A.charAt(i - 1);

            for (int j = 1; j <= bLen; j++) {
                char b = B.charAt(j - 1);

                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[aLen][bLen]);
    }
}
