// 백준 2441 별 찍기 4
package 백준.boj_2441.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append(" ".repeat(i)).append("*".repeat(N-i)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}

/*
입력 예시
 5

출력 예시
 *****
  ****
   ***
    **
     *
 */
