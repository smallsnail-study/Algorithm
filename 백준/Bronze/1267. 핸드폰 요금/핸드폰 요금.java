import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int totalY = 0;
        int totalM = 0;
        
        for (int i =0; i < n; i++) {
            int time = sc.nextInt();
            
            int costY = ((time / 30) + 1) * 10;
            totalY += costY;
            
            int costM = ((time / 60) + 1) * 15;
            totalM += costM;
        }
        sc.close();
        
        if (totalY < totalM)
            System.out.println("Y " + totalY);
        else if (totalM < totalY)
            System.out.println("M " + totalM);
        else
            System.out.println("Y M " + totalY);
    }
}