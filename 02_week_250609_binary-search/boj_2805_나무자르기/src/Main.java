import java.io.BufferedReader;
import java.io.InputStreamReader;
// import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer initialInput = new StringTokenizer(br.readLine());

        int treeCount = Integer.parseInt(initialInput.nextToken());
        int requiredWoodLength = Integer.parseInt(initialInput.nextToken());

        int[] treeHeights = new int[treeCount];
        int maxHeight = 0;

        StringTokenizer heightInput = new StringTokenizer(br.readLine());
        for (int i = 0; i < treeCount; i++) {
            treeHeights[i] = Integer.parseInt(heightInput.nextToken());
            maxHeight = Math.max(maxHeight, treeHeights[i]);
        }
        // Arrays.sort(trees); 굳이 정렬 안 해도 됨.

        // 절단기 높이 0 ~ 가장 높은 나무의 높이
        int start = 0;
        int end = maxHeight;
        int optimalHeight = 0;

        while(start <= end) {
            int cutterHeight = (start + end) / 2;
            long cutWoodLength = 0; // 합이 커질 수 있으므로 long으로


            for (int height : treeHeights) {
                if (height > cutterHeight) {
                    cutWoodLength += height - cutterHeight;
                }                  
            }

            if (cutWoodLength >= requiredWoodLength) {
                optimalHeight = cutterHeight; // 정답이 될 가능성 있음
                start = cutterHeight + 1;
            } else {
                end = cutterHeight - 1;
            }
        }

        System.out.println(optimalHeight);
    }
}
