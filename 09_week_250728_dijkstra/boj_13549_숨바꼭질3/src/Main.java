import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100_000;
    static final int INF = 100_000;    
    static int[] distances;

    private static class Spot implements Comparable<Spot> {
        int time;
        int pos;

        Spot(int time, int pos) {
            this.time = time;
            this.pos = pos;
        }

        @Override
        public int compareTo(Spot other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        distances = new int[MAX + 1];
        Arrays.fill(distances, INF);

        dijkstra(start);

        System.out.println(distances[target]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Spot> pq = new PriorityQueue<>();
        distances[start] = 0;
        pq.offer(new Spot(0, start));

        while (!pq.isEmpty()) {
            Spot current = pq.poll();
            int curTime = current.time;
            int curPos = current.pos;

            if (distances[curPos] < curTime)
                continue;

            // 1) 순간이동 (0초)
            addNextSpot(pq, curPos * 2, curTime);

            // 2) 앞으로 걷기 (1초)
            addNextSpot(pq, curPos + 1, curTime + 1);

            // 3) 뒤로 걷기 (1초)
            addNextSpot(pq, curPos - 1, curTime + 1);
        }
    }

    private static void addNextSpot(PriorityQueue<Spot> pq, int nextPos, int nextTime) {
        if (nextPos < 0 || nextPos > MAX) return;

        if (distances[nextPos] > nextTime) {
            distances[nextPos] = nextTime;
            pq.offer(new Spot(nextTime, nextPos));
        }
    }
}
