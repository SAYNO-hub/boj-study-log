import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] liquids = Arrays.stream(br.readLine().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();
        // 이미 정렬된 상태로 들어와서 정렬 불필요
        
        int left = 0, right = N - 1;

        // 두 용액의 합 절댓값 중에서 '최솟값' 찾기
        // 최소값을 찾는 알고리즘에서 가장 큰 값으로 초기화하는 건 아주 기본적인 테크닉
        int minAbsSum = Integer.MAX_VALUE; 

        int leftValue = 0, rightValue = 0;

        while (left < right) {
            int sum = liquids[left] + liquids[right];
            int absSum = Math.abs(sum);

            if (absSum < minAbsSum) {
                minAbsSum = absSum;
                leftValue = liquids[left];
                rightValue = liquids[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(leftValue + " " + rightValue);
    }
}
