import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visits = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visits[i] = Integer.parseInt(st.nextToken());
        }

        int currentSum = 0; // long 고민

        // 초기 윈도우 합 (처음 X일)
        for (int i = 0; i < X; i++) {
            currentSum += visits[i];
        }

        int maxSum = currentSum; // long 고민
        int count = 1;

        // 인덱스 i는 "새로 추가되는 날"의 위치
        for (int i = X; i < N; i++) {
            currentSum += visits[i];
            currentSum -= visits[i - X];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                count = 1;
            } else if (currentSum == maxSum) {
                count++;
            }
        }

        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(count);
        }
    }
}
