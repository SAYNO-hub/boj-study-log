import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int regionCount = Integer.parseInt(br.readLine());
        
        int[] requests = new int[regionCount];
        int maxRequest = 0;

        StringTokenizer requestsInput = new StringTokenizer(br.readLine());
        for(int i = 0; i < regionCount; i++) {
            requests[i] = Integer.parseInt(requestsInput.nextToken());
            maxRequest = Math.max(maxRequest, requests[i]);
        }

        int totalBudget = Integer.parseInt(br.readLine());

        int start = 1;
        int end = maxRequest; // 생각하기 싫으면 intMAX longMAX 넣으면 됨
        int maxAffordableLimit = 0;

        // 초과보다 이상일 때가 더 경우가 많음 (초과 : 경계값을 건너뛸 수 있음)
        while (start <= end) {
            int upperLimit = (start + end) / 2;
            long sumAllocated = 0;

            for (int request : requests) {
                sumAllocated += Math.min(request, upperLimit);
            }

            // 최대값이니까 오른쪽 절반에 = 넣으면 됨
            // 최소값은 왼쪽 절반에 포함되어야 하니까 거기에 = 넣기
            if (sumAllocated <= totalBudget) {
                maxAffordableLimit = upperLimit;
                start = upperLimit + 1;
            } else {
                end = upperLimit - 1;
            }
        }

        System.out.println(maxAffordableLimit);
    }
}
