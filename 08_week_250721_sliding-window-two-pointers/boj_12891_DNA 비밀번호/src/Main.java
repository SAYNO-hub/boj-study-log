import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] required = new int[4]; // A, C, G, T의 최소 개수
    static int[] current = new int[4];  // 현재 슬라이딩 윈도우 내 개수
    static int result = 0;
    static char[] dna;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 비밀번호 길이 (슬라이딩 윈도우 크기)

        dna = br.readLine().toCharArray(); // DNA 문자열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            required[i] = Integer.parseInt(st.nextToken()); // A, C, G, T 최소 개수
        }

        // 초기 윈도우 채우기
        for (int i = 0; i < P; i++) {
            add(dna[i]);
        }

        // 초기 윈도우 검사
        if (isValid()) result++;

        // 슬라이딩 윈도우 진행
        for (int i = P; i < S; i++) {
            add(dna[i]);           // 오른쪽에 새로 들어온 문자 추가
            remove(dna[i - P]);    // 왼쪽에서 빠진 문자 제거
            if (isValid()) result++;
        }

        System.out.println(result);
    }

    // 현재 윈도우가 조건을 만족하는지 확인
    private static boolean isValid() {
        for (int i = 0; i < 4; i++) {
            if (current[i] < required[i]) return false;
        }
        return true;
    }

    // 문자 하나 추가
    private static void add(char c) {
        switch (c) {
            case 'A': current[0]++; break;
            case 'C': current[1]++; break;
            case 'G': current[2]++; break;
            case 'T': current[3]++; break;
        }
    }

    // 문자 하나 제거
    private static void remove(char c) {
        switch (c) {
            case 'A': current[0]--; break;
            case 'C': current[1]--; break;
            case 'G': current[2]--; break;
            case 'T': current[3]--; break;
        }
    }
}
