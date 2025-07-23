import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            int bookCount = Integer.parseInt(br.readLine());
            Map<String, Integer> booksMap = new HashMap<>();

            for (int i = 0; i < bookCount; i++) {
                String line = br.readLine();

                booksMap.put(line, booksMap.getOrDefault(line, 0) + 1);
            }

            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(booksMap.entrySet());

            sortedEntries.sort((e1, e2) -> {
                int freqCompare = Integer.compare(e2.getValue(), e1.getValue());
                if (freqCompare != 0) return freqCompare; // 빈도 내림차순

                return e1.getKey().compareTo(e2.getKey()); // 사전순 오름차순
            });

            String result = sortedEntries.get(0).getKey();
            System.out.println(result);

            br.close();
        }
    }
}
