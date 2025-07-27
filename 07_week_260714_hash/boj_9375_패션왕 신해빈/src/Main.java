import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int clothCount = Integer.parseInt(br.readLine());
            Map<String, Integer> categoryCount = new HashMap<>();

            for (int i = 0; i < clothCount; i++) {
                String[] input = br.readLine().split(" ");
                String cloth = input[0]; // 필요는 없지만 입력은 받아야 함
                String category = input[1];

                categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
            }
            
            int result = 1;
            for (int count : categoryCount.values()) {
                result *= (count + 1); // 안 입는 경우 포함
            }

            result -= 1; // 아무것도 안 입는 경우 제거
            System.out.println(result);
        }

    }
}
