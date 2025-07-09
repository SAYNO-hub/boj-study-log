import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static class Weight {
        int min, count;

        Weight(int min, int count) {
            this.min = min;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        int minRope = 0;

        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);
        minRope = ropes[0];
        
        Weight curWeight = new Weight(minRope, N);
        Weight maxWeight = new Weight(minRope, N);

        for (int i = 1; i < N; i++) {
            if (curWeight.min <= ropes[i]) {
                curWeight.min = ropes[i];
                curWeight.count = curWeight.count - 1;
            }

            int current = curWeight.min * curWeight.count;
            int max = maxWeight.min * maxWeight.count;

            if (current <= max) continue;

            maxWeight.min = curWeight.min;
            maxWeight.count = curWeight.count; 
        }

        int max = maxWeight.min * maxWeight.count;
        System.out.println(max);
    }
}
