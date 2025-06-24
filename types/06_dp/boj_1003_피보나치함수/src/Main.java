import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        // int[] testcases = new int[T];
        // for(int i = 0; i < T; i++) {
        //     testcases[i] = Integer.parseInt(br.readLine());
        // }

        int[] numberOfZero = new int[41];
        int[] numberOfOne = new int[41];

        numberOfZero[0] = 1;
        numberOfOne[0] = 0;
        numberOfZero[1] = 0;
        numberOfOne[1] = 1;

        for(int i = 2; i < 41 ;i++) {
            numberOfZero[i] = numberOfZero[i-1] + numberOfZero[i-2];
            numberOfOne[i] = numberOfOne[i-1] + numberOfOne[i-2];
        }

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(numberOfZero[n] + " " + numberOfOne[n]).append('\n');
        }
        
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}

