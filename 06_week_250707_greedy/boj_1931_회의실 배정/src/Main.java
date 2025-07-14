import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Time {
        int start, end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            List<Time> meetings = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                meetings.add(new Time(start, end));
            }

            // 1. end 기준 오름차순 정렬
            // 2. end 같으면 start 기준 오름차순 정렬
            meetings.sort((a, b) -> {
                if (a.end == b.end) return a.start - b.start;
                return a.end - b.end;
            });

            // 회의 선택
            int now = 0;
            int cnt = 0;
            for (Time t : meetings) {
                if (t.start >= now) {
                    cnt++;
                    now = t.end;
                }
            }

            System.out.println(cnt);

            // 예시: meetings 전체 출력
            // for (Time t : meetings) {
            //     System.out.println("start: " + t.start + ", end: " + t.end);
            // }
        }

    }
}
