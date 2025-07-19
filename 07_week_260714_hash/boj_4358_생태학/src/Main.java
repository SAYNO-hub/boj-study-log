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

        String input;
        while ((input = br.readLine()) != null && !input.equals("")) {
            speciesMap.put(input, speciesMap.getOrDefault(input, 0) + 1);
            totalCount++;
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(speciesMap.entrySet());
        
        // 기존 정렬 방식 
        // entries.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));

        // 알파벳 오름차순 정렬
        entries.sort(Map.Entry.comparingByKey());

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entries) {
            float percent = (float) entry.getValue() * 100 / totalCount;

            sb.append(entry.getKey()).append(" ");
            sb.append(String.format("%.4f", percent)).append("\n");
        }

        System.out.println(sb);
    }
}
