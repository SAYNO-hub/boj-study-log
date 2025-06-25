import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int curSum = 0;
            int maxSum = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int val = Integer.parseInt(st.nextToken());

                // Kadane's step: 이번 원소로 시작 vs. 이어붙이기
                curSum = Math.max(val, curSum + val);
                maxSum = Math.max(maxSum, curSum);            
            }
            
            System.out.println(maxSum);
        }
    }
}

// public static void main(String[] args) throws Exception {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//     int n = Integer.parseInt(br.readLine());
//     int[] integers = new int[n];
//     StringTokenizer st = new StringTokenizer(br.readLine());
//     for (int i = 0; i < n; i++) {
//         integers[i] = Integer.parseInt(st.nextToken());
//     }
    
//     int[] dp = new int[n];
//     dp[0] = integers[0];
//     int max = dp[0];
//     for (int i = 1; i < n; i++) {
//         dp[i] = Math.max(integers[i], dp[i-1] + integers[i]);
//         max = Math.max(max, dp[i]);
//     }
    
//     System.out.println(max);
// }