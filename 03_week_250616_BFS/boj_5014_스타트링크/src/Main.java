import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int totalFloors, start, goal;
    static int up, down;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        totalFloors = Integer.parseInt(input.nextToken());
        start = Integer.parseInt(input.nextToken());
        goal = Integer.parseInt(input.nextToken());
        up = Integer.parseInt(input.nextToken());
        down = Integer.parseInt(input.nextToken());

        visited = new boolean[totalFloors + 1];

        int result = bfs(start);

        System.out.println(result >= 0 ? result : "use the stairs");
    }

    private static int bfs(int startFloor) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startFloor] = true;
        queue.add(new int[]{startFloor, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int floor = now[0];
            int count = now[1];
        
            if (floor == goal) return count;

            int upFloor = floor + up;
            int downFloor = floor - down; 

            if (upFloor <= totalFloors && !visited[upFloor]) {
                visited[upFloor] = true;
                queue.add(new int[]{upFloor, count + 1});
            }

            if (downFloor >= 1 && !visited[downFloor]) {
                visited[downFloor] = true;
                queue.add(new int[]{downFloor, count + 1});
            }
        }

        return -1;
    }
}
