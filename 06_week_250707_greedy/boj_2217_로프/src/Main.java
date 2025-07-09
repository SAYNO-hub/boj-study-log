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

        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes); // 오름차순 정렬

        
        Weight maxWeight = new Weight(ropes[0], N); // 초기값

        for (int i = 0; i < N; i++) {

            int min = ropes[i]; // 현재 사용할 최소 무게
            int count = N - i; // 남은 로프 수
            int current = min * count;

            if (current > maxWeight.min * maxWeight.count) {
                maxWeight.min = min;
                maxWeight.count = count; 
            }

        }

        System.out.println(maxWeight.min * maxWeight.count);
    }
}
