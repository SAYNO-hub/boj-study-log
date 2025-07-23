import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {

            int logCount = Integer.parseInt(br.readLine());
            Set<String> peopleInOffice = new HashSet<>();

            for (int i = 0; i < logCount; i++) {
                String[] log = br.readLine().split(" ");
                String name = log[0];
                String action = log[1];

                if (action.equals("leave")) {
                    peopleInOffice.remove(name);
                } else {
                    peopleInOffice.add(name);
                }
            }

            List<String> sortedNames = new ArrayList<>(peopleInOffice);
            sortedNames.sort(Comparator.reverseOrder());

            for (String name : sortedNames) {
                bw.write(name);
                bw.newLine();
            }

            bw.flush(); // 반드시 flush!
            bw.close();
            br.close();
        }
    }
}
