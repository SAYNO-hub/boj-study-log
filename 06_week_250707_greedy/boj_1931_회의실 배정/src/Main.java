import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int N;
    static Map<Integer, List<Time>> meetings = new TreeMap<>();

    static class Time {
        int end, start;

        Time(int end, int start) {
            this.end = end;
            this.start = start;
        }
    }

    private static int maxMeetingCount(int start) {
        int cnt = 0;
        int now = 0;

        for (int key : meetings.keySet()) {
            for (Time t : meetings.get(key)) {
                if (t.start >= now) {
                    ++cnt;
                    now = t.end;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                meetings.computeIfAbsent(end, k -> new ArrayList<>()).add(new Time(end, start));
            }

            // end가 같은 회의들 사이에서 start가 빠른 순으로 정렬
            for (int key : meetings.keySet()) {
                meetings.get(key).sort((a, b) -> a.start - b.start);
            }


            // 예시: meetings 전체 출력
            // for (int key : meetings.keySet()) {
            //     System.out.println("end = " + key);
            //     for (Time t : meetings.get(key)) {
            //         System.out.println("  → start at: " + t.start);
            //     }
            // }

            System.out.println(maxMeetingCount(0));
        }

    }
}
