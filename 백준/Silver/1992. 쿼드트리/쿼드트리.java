import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }
        quadtreeCompress(matrix, 0, 0, n);
        System.out.print(sb.toString());
    }
    
    private static int isUniform(int[][] matrix, int x, int y, int size) {
        int firstColor = matrix[x][y];

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (matrix[i][j] != firstColor) {
                    return -1;
                }
            }
        }
        return firstColor;
    }

    private static void quadtreeCompress(int[][] matrix, int x, int y, int size) {
        int color = isUniform(matrix, x, y, size);
        if (color != -1) {
            sb.append(color);
            return;
        }

        sb.append("(");
        int half = size / 2;
        quadtreeCompress(matrix, x, y, half);
        quadtreeCompress(matrix, x, y+half, half);
        quadtreeCompress(matrix, x+half, y, half);
        quadtreeCompress(matrix, x+half, y+half, half);
        sb.append(")");
    }
}