import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * Greedy : 가장 큰 동전부터 차감하여 최소 동전 개수를 계산한다.
     * @param coins 오름차순 정렬된 동전 단위
     * @param amount 목표 금액
     * @return 동전 최소 개수
     */
    private static int minCoinCount(int[] coins, int amount) {
        int cnt = 0;

        for (int i = coins.length - 1; i >= 0 ; i--) {
            if (coins[i] > amount) continue;
            cnt += amount / coins[i];
            amount %= coins[i];

            if (amount == 0) break;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            System.out.println(minCoinCount(coins, K));
        }        
    }
}
