import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Spot>[] graph;
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

        distances = new int[100000 + 1];
        Arrays.fill(distances, 100000);

        dijkstra(start);

        System.out.println(distances[target]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Spot> pq = new PriorityQueue<>();
        pq.offer(new Spot(0, start));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Spot current = pq.poll();
            int curTime = current.time;
            int curPos = current.pos;

            if (distances[curPos] < curTime)
                continue;

            // 1) 순간이동 (가중치 0)
            int nextPos = 2 * curPos;
            int nextTime = curTime;
            if ((nextPos <= 100000) && (distances[nextPos] > nextTime)) {
                distances[nextPos] = nextTime;
                pq.add(new Spot(nextTime, nextPos));
            }

            // 2) 앞으로 걷기 (가중치 1)
            nextPos = curPos + 1;
            nextTime = curTime + 1;
            if ((nextPos <= 100000) && (distances[nextPos] > nextTime)) {
                distances[nextPos] = nextTime;
                pq.add(new Spot(nextTime, nextPos));
            }

            // 3) 뒤로 걷기 (가중치 1)
            nextPos = curPos - 1;
            nextTime = curTime + 1;
            if ((0 <= nextPos) && (distances[nextPos] > nextTime)) {
                distances[nextPos] = nextTime;
                pq.add(new Spot(nextTime, nextPos));
            }
        }
    }
}
