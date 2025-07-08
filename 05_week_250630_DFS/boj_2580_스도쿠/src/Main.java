import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
    }

    static boolean solve(int row, int col) {
        if(col == 9) {
            return solve(row + 1, 0); // 다음 행 시작
        }

        if(row == 9) {
            printBoard();
            return true; // 모든 칸 채움
        }

        if(board[row][col] != 0) {
            return solve(row, col + 1); // 이미 채워진 칸은 넘김
        }

        for(int num = 1; num <= 9; num++) {
            if(isValid(row, col, num)) {
                board[row][col] = num; // 1. 현재 빈 칸에 num을 넣음

                if(solve(row, col + 1)) { // 2. 다음 칸(열+1)부터 재귀 탐색 시작
                    return true;  // 3. 만약 정답이 되면 바로 true 반환해서 탐색 종료
                }
                board[row][col] = 0; // 4. 실패하면 원상복구 (백트래킹)
            }
        }

        return false; // 못 채우면 false 반환
    }

    static boolean isValid(int row, int col, int num) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == num) return false; // 행 검사
            if(board[i][col] == num) return false; // 열 검사
        }

        int startRow = (row / 3) * 3; // 시작점 찾기
        int startCol = (col / 3) * 3; // 시작점 찾기
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == num) return false; // 박스 검사
            }
        }

        return true;
    }

    static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                sb.append(board[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}