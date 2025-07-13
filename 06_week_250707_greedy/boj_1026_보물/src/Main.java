import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[][] bWithIndex = new int[N][2]; // [B값, 원래 인덱스]

        // 입력
        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stA.nextToken());
            B[i] = Integer.parseInt(stB.nextToken());

            bWithIndex[i][0] = B[i]; // 값
            bWithIndex[i][1] = i;    // 원래 인덱스
        }

        // 정렬
        Arrays.sort(A); // A : 오름차순 
        Arrays.sort(bWithIndex, (a, b) -> Integer.compare(b[0], a[0])); // B를 값 기준 내림차순 정렬 = 2차원 배열 C를 첫 번째 열 기준으로 내림차순 정렬

        // 계산 (A의 작은 값과 B의 큰 값 매칭)
        int result = 0;
        for (int i = 0; i < N; i++) {
            int bIndex = bWithIndex[i][1]; // B의 원래 위치
            result += A[i] * B[bIndex]; // 고정된 B와 오름차순된 A를 곱함
        }

        System.out.println(result);
    }
}

/*
 * 자바에서 Comparator가 동작하는 방식
 * 
 * Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));
 * 
 * 이 안의 Integer.compare(a[0], b[0]) 결과값은:
 * 음수 → a가 b보다 "앞에" 있어야 한다 (자리 유지)
 * 0 → a와 b는 같은 순서로 취급 (자리 유지)
 * 양수 → a가 b보다 "뒤에" 있어야 한다 (자리 바꿈)
 * 
 * 자바의 Comparator는 
 * "앞에 있는 값 a와 뒤에 있는 값 b를 비교해서"
 * a - b가 양수면 자리 바꿈, 음수면 그대로 유지한다.
 * 그래서 a < b이면 음수 → 자리 유지 → 오름차순이 된다.
 */