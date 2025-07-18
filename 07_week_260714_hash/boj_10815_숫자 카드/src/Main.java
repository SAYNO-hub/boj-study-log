import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet <Integer> numSet = new HashSet<>();

        StringTokenizer stN = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numSet.add(Integer.parseInt(stN.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer stM = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(stM.nextToken());
            sb.append(numSet.contains(num) ? "1 " : "0 ");
        }

        System.out.println(sb);
    }
}
