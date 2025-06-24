import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        System.out.println(recur(N, 0));
    }

    static int recur(int N, int count) {
        // N이 1이 되면 누적된 count값 반환
        if (N < 2) { 
            return count;
        } 
        return Math.min(recur(N / 2, count + 1 + (N % 2)), recur(N / 3, count + 1 + (N % 3)));
        /*
          N / 2 하는 경우, 실제 연산 횟수는 
          (1) 2로 나누기 전 나머지(N % 2)를 빼기 1로 처리 > count (N % 2) 만큼 증가
          (2) 2로 나누기 > count 1 증가
          그래서 기존의 N은 N/2가 되고, 연산 횟수는 count + 1 + (N % 2) 가 된다.
        */
        
        /*
          N / 3 하는 경우, 실제 연산 횟수는 
          (1) 3로 나누기 전 나머지(N % 3)를 빼기 1로 처리 > count (N % 3) 만큼 증가
          (2) 3로 나누기 > count 1 증가
          그래서 기존의 N은 N/2가 되고, 연산 횟수는 count + 1 + (N % 3) 가 된다.
        */

        /*
          3의 배수인 경우 3으로 나누고, 2의 배수면 2로 나누는 것이 제일 최소 연산
          6의 배수 일 경우를 처리하기 위해 min 으로 두 가능성을 모두 고려해서
          최종 누적된 count 값 중 최소 연산 값을 min 으로 추출
        */
    }
}

/* 2번째 알고리즘

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	static Integer[] dp;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		dp = new Integer[N + 1];
		dp[0] = dp[1] = 0;
 
		System.out.print(recur(N));
 
	}
 
	static int recur(int N) {
 
		if (dp[N] == null) {
			// 6으로 나눠지는 경우 
			if (N % 6 == 0) {
				dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
			}
			// 3으로만 나눠지는 경우 
			else if (N % 3 == 0) {
				dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
			}
			// 2로만 나눠지는 경우 
			else if (N % 2 == 0) {
				dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			else {
				dp[N] = recur(N - 1) + 1;
			}
		}
		return dp[N];
	}
 
}
 
 */