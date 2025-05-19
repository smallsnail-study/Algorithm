import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int[] totalCounts = countColors(matrix, 0, 0, n);
        System.out.println(totalCounts[0]);
        System.out.println(totalCounts[1]);
    }
    
    private static String checkColor(int[][] matrix, int x, int y, int size) {
        int firstColor = matrix[x][y];
        
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if (matrix[i][j] != firstColor)
                    return "mixed";
            }
        }
        
        if (firstColor == 0)
            return "white";
        else
            return "blue";
    }
    
    private static int[] countColors(int[][] matrix, int x, int y, int size) {
        String state = checkColor(matrix, x, y, size);
        
        if (state.equals("white"))
            return new int[]{1, 0};
        else if (state.equals("blue"))
            return new int[]{0, 1};
        
        int half = size / 2;
        int[] counts1 = countColors(matrix, x, y, half);
        int[] counts2 = countColors(matrix, x, y+half, half);
        int[] counts3 = countColors(matrix, x+half, y, half);
        int[] counts4 = countColors(matrix, x+half, y+half, half);
        
        int totalWhite = counts1[0] + counts2[0] + counts3[0] + counts4[0];
        int totalBlue = counts1[1] + counts2[1] + counts3[1] + counts4[1];
        return new int[]{totalWhite, totalBlue};
    }
}