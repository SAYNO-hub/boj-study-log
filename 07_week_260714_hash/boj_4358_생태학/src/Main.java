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
        
        entries.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));
        

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < entries.size(); i++) {
            float percent = (float) entries.get(i).getValue() / totalCount * 100;
            String result = String.format("%.4f", percent);

            sb.append(entries.get(i).getKey()).append(" ");
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
