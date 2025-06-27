import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String A = br.readLine();
            String B = br.readLine();
            System.out.println(lcsLength(A, B));
        }
    }

    // 두 문자열의 LCS 길이 반환
    private static int lcsLength(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();

        // dp[i][j] : A의 앞 i글자, B의 앞 j글자의 LCS 길이
        int[][] dp = new int[lenA + 1][lenB + 1];

        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                char a = A.charAt(i - 1);
                char b = B.charAt(j - 1);

                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

       return dp[lenA][lenB];
    }
}
