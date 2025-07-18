import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap <String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M)  continue;

            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordMap.entrySet());

        // 정렬: 빈도 내림차순 → 길이 내림차순 → 사전순 오름차순
        entries.sort((e1, e2) -> {
            int freqCompare = Integer.compare(e2.getValue(), e1.getValue()); // 빈도 내림차순
            if (freqCompare != 0) return freqCompare;

            int lenCompare = Integer.compare(e2.getKey().length(), e1.getKey().length()); // 길이 내림차순
            if (lenCompare != 0) return lenCompare;

            return e1.getKey().compareTo(e2.getKey()); // 사전순 오름차순
        });

        // 시간 초과난 출력 부분
        // for (Map.Entry<String, Integer> entry : entries) {
        //     System.out.println(entry.getKey());
        // }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entries) {
            sb.append(entry.getKey()).append('\n');
        }

        System.out.print(sb);
    }
}
