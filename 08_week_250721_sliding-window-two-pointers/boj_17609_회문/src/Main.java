import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 회문 : 앞에서 읽으나 뒤에서 읽으나 같은 문자열

public class Main {
    static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    static int checkPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 한쪽 문자를 제거하고 검사
                if (isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1)) {
                    return 1; // 유사 회문 : 한 문자를 삭제하여 회문이 될 때
                } else {
                    return 2; // 회문 아님
                }
            }
            left++;
            right--;
        }
        return 0; // 회문
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            System.out.println(checkPalindrome(s));
        }
    }
}
