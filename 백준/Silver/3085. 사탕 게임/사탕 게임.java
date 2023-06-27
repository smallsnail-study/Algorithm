import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void swap(char[][] board, int r1, int c1, int r2, int c2) {
        char tmp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = tmp;
    }

    public static int findMaxRow(char[][] board) {
        int N = board.length;
        int maxRow = 0;
        for (int r = 0; r < N; r++) {
            int len = 1;
            for (int c = 1; c < N; c++) {
                if (board[r][c] == board[r][c - 1]) {
                    len++;
                } else {
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len);
        }
        return maxRow;
    }
    public static int findMaxColumn(char[][] board) {
        int N = board.length;
        int maxColumn = 0;
        for (int c = 0; c < N; c++) {
            int len = 1;
            for (int r = 1; r < N; r++) {
                if (board[r][c] == board[r - 1][c]) {
                    len++;
                } else {
                    maxColumn = Math.max(maxColumn, len);
                    len = 1;
                }
            }
            maxColumn = Math.max(maxColumn, len);
        }
        return maxColumn;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && board[i][j] != board[i][j + 1]) {
                    swap(board, i, j, i, j + 1);
                    ans = Math.max(ans, Math.max(findMaxRow(board), findMaxColumn(board)));
                    swap(board, i, j, i, j + 1);
                }
                if (i + 1 < N && board[i][j] != board[i + 1][j]) {
                    swap(board, i, j, i + 1, j);
                    ans = Math.max(ans, Math.max(findMaxRow(board), findMaxColumn(board)));
                    swap(board, i, j, i + 1, j);
                }
            }
        }
        System.out.println(ans);
    }
}