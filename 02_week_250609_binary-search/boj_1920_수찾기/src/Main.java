import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        long[] B = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            B[j] = Long.parseLong(st.nextToken());
        }

        int isItExist = 0;
        for (int j = 0; j < M; j++) {
            long target = B[j];
            int idx = Arrays.binarySearch(A, target);

            if (idx >= 0) isItExist = 1;

            System.out.println(isItExist);
            isItExist = 0;
        }
    }
}
