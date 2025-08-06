import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer initialInput = new StringTokenizer(br.readLine());
        int ownedCables = Integer.parseInt(initialInput.nextToken());
        int requiredCables = Integer.parseInt(initialInput.nextToken());
        
        int[] cableLengths = new int[ownedCables];
        int maxLength = 0;

        for (int i = 0; i < ownedCables; i++) {
            cableLengths[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(maxLength, cableLengths[i]);
        }

        long start = 1;
        long end = maxLength;
        long optimalLength = 0;

        while (start <= end) {
            long cuttingLength = (start + end) / 2;
            long cutCablesCount = 0;

            for (int length : cableLengths) {
                cutCablesCount += length / cuttingLength;
            }

            if (cutCablesCount >= requiredCables) {
                optimalLength = cuttingLength;
                start = cuttingLength + 1;
            } else {
                end = cuttingLength - 1;
            }
        }

        System.out.println(optimalLength);
    }
}
