import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][] arr = new int[9][9];
        int maxValue = -1;
        int maxRow = 0;
        int maxCol = 0;
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                    maxRow = i + 1;
                    maxCol = j + 1;
                }
            }
        }
        System.out.println(maxValue);
        System.out.println(maxRow + " " + maxCol);
    }
}