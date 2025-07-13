import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] applicants = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applicants, (a, b) -> Integer.compare(a[0], b[0])); // applicants : 서류 성적 기준 오름차순 정렬

            int maxNum = 1;
            int compareRank = applicants[0][1];

            for (int i = 1; i < N; i++) {
                int rank = applicants[i][1];

                if (compareRank > rank) 
                    ++maxNum;
                    compareRank = rank;

            }

            System.out.println(maxNum);
        }
    }
}
