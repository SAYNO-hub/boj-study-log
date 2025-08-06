import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 추가


        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map <String, Integer> wordMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M)  continue;

            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordMap.entrySet());

        // 정렬: 빈도 ↓, 길이 ↓, 사전순 ↑
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

        // StringBuilder sb = new StringBuilder();
        // for (Map.Entry<String, Integer> entry : entries) {
        //     sb.append(entry.getKey()).append('\n');
        // }

        // System.out.print(sb);

        // 출력 - 문제에서 추천하는 출력 방식
        for (Map.Entry<String, Integer> entry : entries) {
            bw.write(entry.getKey());
            bw.newLine();
        }

        bw.flush(); // 반드시 flush!
        bw.close();
    }
}
