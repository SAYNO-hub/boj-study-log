package 백준.boj_2442.src;

// 백준 2442 별 찍기 5
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N ; i++) {
            sb.append(" ".repeat(N-i)).append("*".repeat(2*i-1)).append(" ".repeat(N-i)).append("\n");
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
    ***
   *****
  *******
 *********
 
*/