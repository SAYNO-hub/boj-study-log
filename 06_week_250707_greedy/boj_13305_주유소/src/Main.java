import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] roads = new int[N - 1];
        int[] prices = new int[N];

        StringTokenizer stRoad = new StringTokenizer(br.readLine());
        StringTokenizer stPrice = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            roads[i] = Integer.parseInt(stRoad.nextToken());
            prices[i] = Integer.parseInt(stPrice.nextToken());
        }
        prices[N - 1] = Integer.parseInt(stPrice.nextToken());

        long firstExpense = (long) roads[0] * prices[0];
        long result = firstExpense;
        int beforePrice = prices[0];

        for (int i = 1; i < N - 1; i++) {
            if (beforePrice > prices[i]) {
                beforePrice = prices[i];
            }
            result += (long) roads[i] * beforePrice;
        }

        System.out.println(result);
    }
}
 