import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // 한 줄 입력을 받고, 그것이 "0"이 아니라면 반복 계속
        // "0"이 입력되면 반복 종료 (종료 조건)
        while (!(input = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(input);
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            output = new int[6];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("\n");  // 각 테스트 케이스 사이 빈 줄
        }

        System.out.print(sb.toString());
    }

    /** 백트래킹 (조합)
    * @param depth   현재까지 선택한 개수 (0~6)
    * @param start   다음으로 선택 가능한 인덱스 시작점
    */

    static void dfs(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) sb.append(output[i]).append(" ");
            sb.append("\n");
            return;
        }

        // i는 항상 이전 선택(index)보다 큰 값 → 오름차순 + 중복 제거
        for (int i = start; i < k; i++) {
            output[depth] = arr[i];
            dfs(depth + 1, i + 1);  // 조합: i+1부터 시작
        }
    }
}