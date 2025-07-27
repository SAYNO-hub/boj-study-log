import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());

            while (testCases-- > 0) {
                int clothCount = Integer.parseInt(br.readLine());
                Map<String, Integer> categoryCount = new HashMap<>();

                for (int i = 0; i < clothCount; i++) {
                    String[] input = br.readLine().split(" ");
                    String category = input[1];

                    categoryCount.compute(category, (key, val) -> val == null ? 1 : val + 1);
                }

                System.out.println(getCombinationCount(categoryCount));
            }
        }
    }

    private static int getCombinationCount(Map<String, Integer> categoryCount) {
        int result = 1;
        for (int count : categoryCount.values()) {
            result *= (count + 1); // 안 입는 경우 포함
        }
        return result - 1; // 아무것도 안 입는 경우 제외
    }
}
