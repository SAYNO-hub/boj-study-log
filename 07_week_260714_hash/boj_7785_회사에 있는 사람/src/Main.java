import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> logSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            String name = line[0];
            String action = line[1];

            if (action.equals("leave")) {
                logSet.remove(name);
            } else {
                logSet.add(name);
            }
        }

        List<String> sortedEntries = new ArrayList<>(logSet);
        sortedEntries.sort(Comparator.reverseOrder());

        for (String name : sortedEntries) {
            bw.write(name);
            bw.newLine();
        }

        bw.flush(); // 반드시 flush!
        bw.close();
        br.close();
    }
}
