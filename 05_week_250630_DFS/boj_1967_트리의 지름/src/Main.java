import java.io.*;
import java.util.*;

public class Main {
    static int N;  // 노드 개수
    static ArrayList<Node>[] tree;  // 인접 리스트: 각 노드와 연결된 노드 및 가중치 저장
    static boolean[] visited;  // 방문 여부 체크용 배열

    // 간선 정보 저장용 클래스 (연결된 노드 번호와 간선 가중치)
    static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int maxDist = 0;  // 현재까지 찾은 최대 거리
    static int maxNode = 0;  // 최대 거리를 가진 노드 번호

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 노드 수 입력받기

        // 인접 리스트 초기화
        tree = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 간선 정보 입력 받기 (N-1개의 간선)
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 양방향 간선 추가 (트리는 무방향 그래프)
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        // 1번 노드에서 가장 먼 노드를 찾기 위해 방문 배열 초기화
        visited = new boolean[N + 1];
        dfs(9, 0);  // dfs 탐색 시작 (현재 노드: 1, 거리: 0)

        // 첫 번째 dfs 결과 가장 먼 노드가 maxNode에 저장됨
        int startNode = maxNode;  // 두 번째 dfs는 이 노드에서 시작

        // 두 번째 dfs를 위해 방문 배열 다시 초기화
        maxDist = 0;  // 최대 거리 초기화
        visited = new boolean[N + 1];

        // 가장 먼 노드에서 다시 dfs 탐색하여 트리의 지름 찾기
        dfs(startNode, 0);

        // dfs 완료 후 maxDist에 트리의 지름(가장 긴 거리)이 저장됨
        System.out.println(maxDist);
    }

    /**
     * DFS 함수
     * @param node 현재 방문 중인 노드 번호
     * @param dist 현재 노드까지의 누적 거리
     */

    static void dfs(int node, int dist) {
        visited[node] = true;  // 현재 노드 방문 처리

        // 현재 누적 거리가 기존 최대 거리보다 크면 갱신
        if(dist > maxDist) {
            maxDist = dist;  // 최대 거리 업데이트
            maxNode = node;  // 최대 거리를 가진 노드도 업데이트
        }

        // 현재 노드와 연결된 모든 인접 노드 탐색
        for(Node next : tree[node]) {
            if(!visited[next.to]) {  // 방문하지 않은 노드면
                // 연결된 노드로 이동, 거리 누적해서 재귀 호출
                dfs(next.to, dist + next.weight);
            }
        }
    }
}

/**
 * 요약
    첫 dfs: 루트(1번)에서 가장 먼 노드를 찾음 (maxNode)

    두 번째 dfs: 첫 dfs에서 찾은 노드(maxNode)에서 가장 먼 노드를 다시 찾음 → 그 거리 = 트리의 지름

    visited 배열은 방문 처리 용도로 DFS마다 초기화해 줌

    누적 거리를 파라미터로 넘겨가며 가장 먼 거리와 노드를 계속 업데이트
 */