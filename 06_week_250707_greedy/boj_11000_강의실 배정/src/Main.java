import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][2]; // [start, end] 시간 저장

        // 수업 정보 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken()); // start
            lectures[i][1] = Integer.parseInt(st.nextToken()); // end
        }

        // 시작 시간 기준 정렬
        Arrays.sort(lectures, (a, b) -> Integer.compare(a[0], b[0]));

        // 강의실 끝나는 시간들을 저장하는 우선순위 큐 (가장 빨리 끝나는 강의실 먼저)
        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();
        roomEndTimes.offer(lectures[0][1]); // 첫 수업의 종료시간으로 초기화

        // 두 번째 수업부터 반복
        for (int i = 1; i < N; i++) {
            int currentStart = lectures[i][0];
            int currentEnd = lectures[i][1];

            // 가장 빨리 끝나는 강의실이 현재 수업보다 먼저 끝났다면 재사용
            if (roomEndTimes.peek() <= currentStart) {
                roomEndTimes.poll();
            }

            // 현재 수업 종료시간 추가 (새 강의실이든, 재사용이든)
            roomEndTimes.offer(currentEnd);
        }

        // 큐에 남아있는 종료시간 개수 = 필요한 최소 강의실 수
        System.out.println(roomEndTimes.size());
    }
}
