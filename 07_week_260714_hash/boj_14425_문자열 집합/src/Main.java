import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> words = new HashMap<>();    

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words.put(word, 1);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String question = br.readLine();

            if (words.containsKey(question)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}