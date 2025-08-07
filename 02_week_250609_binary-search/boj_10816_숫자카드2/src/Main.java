import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder counts = new StringBuilder();

        int cardCount = Integer.parseInt(br.readLine());
        int[] ownedCards = new int[cardCount];
        StringTokenizer cardInput = new StringTokenizer(br.readLine());
        for (int i = 0; i < cardCount; i++) {
            ownedCards[i] = Integer.parseInt(cardInput.nextToken());
        }
        Arrays.sort(ownedCards);

        int integerCount = Integer.parseInt(br.readLine());
        int[] integers = new int[integerCount];
        StringTokenizer integerInput = new StringTokenizer(br.readLine());
        for (int i = 0; i < integerCount; i++) {
            integers[i] = Integer.parseInt(integerInput.nextToken());
        }
        
        for (int target : integers) {
            // target보다 작지 않은 첫 위치 = 이상 첫 위치
            int lower = lowerBound(ownedCards, target);
            // target보다 큰 첫 위치 = 초과 첫 위치
            int upper = upperBound(ownedCards, target);
            int count = upper - lower;
            counts.append(count + " ");
        }

        System.out.println(counts);
    } 

    private static int lowerBound(int[] cards, int target) {
        int start = 0, end = cards.length; 

        while (start < end) {
            int mid = (start + end) / 2;
            
            if (cards[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start; // target보다 작지 않은 첫 위치
    }

    private static int upperBound(int[] cards, int target) {
        int start = 0, end = cards.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (cards[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start; // target보다 큰 첫 위치
    }
}
