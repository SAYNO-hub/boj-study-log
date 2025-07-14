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

        long totalCost = 0;
        int minPrice = prices[0];

        for (int i = 0; i < N - 1; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            totalCost += (long) roads[i] * minPrice;
        }

        System.out.println(totalCost);
    }
}
 