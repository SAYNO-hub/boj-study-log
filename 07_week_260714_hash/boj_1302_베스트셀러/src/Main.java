import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int bookCount = Integer.parseInt(br.readLine());
        Map<String, Integer> bookFrequency = new HashMap<>();

        for (int i = 0; i < bookCount; i++) {
            String title = br.readLine();
            bookFrequency.put(title, bookFrequency.getOrDefault(title, 0) + 1);
        }

        String bestSeller = Collections.max(
            bookFrequency.entrySet(),
            (a, b) -> {
<<<<<<< HEAD
                int freqCompare = Integer.compare(b.getValue(), a.getValue()); // 빈도 내림차순
                return (freqCompare != 0) ? freqCompare : b.getKey().compareTo(a.getKey()); // 사전순 앞서는 키가 우선이므로 반대로
=======
                int freqCompare = Integer.compare(b.getValue(), a.getValue());
                return (freqCompare != 0) ? freqCompare : a.getKey().compareTo(b.getKey());
>>>>>>> 132890c (refactor: BOJ 1302 베스트셀러)
            }
        ).getKey();

        System.out.println(bestSeller);

        // 기존 코드 : 전체 순위나 상위 N개 등을 구할 때 적합
        // List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(bookFrequency.entrySet());

        // sortedEntries.sort((e1, e2) -> {
        //     int freqCompare = Integer.compare(e2.getValue(), e1.getValue());
        //     if (freqCompare != 0) return freqCompare; // 빈도 내림차순

        //     return e1.getKey().compareTo(e2.getKey()); // 사전순 오름차순
        // });

        // String result = sortedEntries.get(0).getKey();
        // System.out.println(result);

    }
}
