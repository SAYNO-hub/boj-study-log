import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map <String, Integer> speciesMap = new HashMap<>();
        int totalCount = 0;

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            speciesMap.put(line, speciesMap.getOrDefault(line, 0) + 1);
            totalCount++;
        }
        
        // 기존 정렬 방식 
        // entries.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));

        // 알파벳 오름차순 정렬
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(speciesMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByKey());

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            float percentage = (float) entry.getValue() * 100 / totalCount;

            sb.append(entry.getKey()).append(" ")
                .append(String.format("%.4f", percentage))
                .append("\n");
        }

        System.out.println(sb);
    }
}
