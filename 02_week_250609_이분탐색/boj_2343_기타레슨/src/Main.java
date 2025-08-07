import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer initialInput = new StringTokenizer(br.readLine());
        int lectureCount = Integer.parseInt(initialInput.nextToken());
        int blueRayCount = Integer.parseInt(initialInput.nextToken());
    
        StringTokenizer lectureInput = new StringTokenizer(br.readLine());
        int[] lectures = new int[lectureCount];
        int totalLectureLength = 0;
        int maxLectureLength = 0;
        for (int i = 0; i < lectureCount; i++) {
            int length = Integer.parseInt(lectureInput.nextToken());
            lectures[i] = length;
            totalLectureLength += length;
            maxLectureLength = Math.max(maxLectureLength, length);
        }

        int start = maxLectureLength;
        int end = totalLectureLength;
        int answer = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = getBlueRayCount(lectures, mid);

            if (count <= blueRayCount) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static int getBlueRayCount(int[] lectures, int maxLength) {
        int count = 1, sum = 0;

        for (int lecture : lectures) {
            if (sum + lecture > maxLength) {
                count++;
                sum = lecture;
            } else {
                sum += lecture;
            }
        }
        return count;
    }
}

