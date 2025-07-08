import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 

        // 한 자리 소수부터 시작 
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    /**
     * @param num 현재까지 만든 숫자
     * @param depth 현재 자리 수 (N이 되면 출력)
     */

    static void dfs(int num, int depth) {
        if (depth == N) {
            System.out.println(num);
            return;
        }

        // 1 ~ 9 자리를 하나씩 붙여보고 소수면 재귀 진행
        for (int i = 1; i < 10; i++) {
            int next = num * 10 + i;

            if (isPrime(next)) {
                dfs(next, depth + 1);
            }
        }
    }

    // 소수 판별 함수
    static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
