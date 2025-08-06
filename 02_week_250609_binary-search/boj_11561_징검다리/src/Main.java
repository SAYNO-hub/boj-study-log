import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long bridgeCount = Long.parseLong(br.readLine());
            long start = 1;
            long end = (long) Math.sqrt(2L * bridgeCount) + 1; // upper bound 줄임
            long maxCount = 0;


            while (start <= end) {
                long mid = (start + end) / 2;
                long sum = mid * (mid + 1) / 2;

                if (sum <= bridgeCount) {
                    maxCount = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            
            System.out.println(maxCount);
        }
    }
}
