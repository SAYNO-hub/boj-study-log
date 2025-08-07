import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 한 줄에 입력된 정수들을 공백 기준으로 나눠서, int 배열로 바꾸는 코드
        int[] arr = Arrays.stream(br.readLine().split(" ")) // 공백 기준 나눔
                          .mapToInt(Integer::parseInt) // String -> int
                          .toArray(); // int[] 배열로 변환

        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int left = 0, right = n - 1, count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == x) {
                count++;
                left++;
                right--;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}
