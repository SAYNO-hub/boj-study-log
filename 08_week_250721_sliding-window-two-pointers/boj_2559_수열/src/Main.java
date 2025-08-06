import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temperature = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 K개의 합
        int currentSum = 0;
        for(int i = 0; i < K; i++){
            currentSum += temperature[i];
        }
        int maxSum = currentSum;

        // 슬라이딩 윈도우
        for(int i = K; i < N; i++){
            currentSum += temperature[i] - temperature[i - K];
            if(currentSum > maxSum) maxSum = currentSum;
        }

        System.out.println(maxSum);
    }
}
