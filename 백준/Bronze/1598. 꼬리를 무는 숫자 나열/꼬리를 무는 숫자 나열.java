import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int colA = (a - 1) % 4;
        int rowA = (a - 1) / 4;
        int colB = (b - 1) % 4;
        int rowB = (b - 1) / 4;
        
        int result = Math.abs(colA - colB) + Math.abs(rowA - rowB);
        System.out.print(result);
    }
}