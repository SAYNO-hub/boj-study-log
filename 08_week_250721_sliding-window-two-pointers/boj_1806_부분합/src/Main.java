import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 줄 입력: N(수열 길이), S(목표 합)
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        // 두 번째 줄 입력: 수열 숫자들
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE; // 최소 길이 초기화 (큰 값으로)
        int sum = 0;
        int start = 0;

        // end 포인터를 움직이며 부분합 계산
        for (int end = 0; end < N; end++) {
            sum += numbers[end];

            while (sum >= S) {
                minLength = Math.min(minLength, end - start + 1);
                // start 위치 숫자를 부분합에서 빼고 start 증가 (구간 축소)
                sum -= numbers[start++];
            }
        }

        // 최소 길이 출력 (갱신 안 됐다면 0 출력)
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
