// 백준 2439 별 찍기 2
package 백준.boj_2439.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            sb.append(" ".repeat(N-i)).append("*".repeat(i)).append("\n");
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
     *   
    **
   ***
  ****
 *****
 
*/