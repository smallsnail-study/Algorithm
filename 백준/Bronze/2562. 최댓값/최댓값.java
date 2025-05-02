import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int max_value = 0;
        int max_index = 0;
        
        for (int i = 0; i < 9; i++) {
            int num = sc.nextInt();
            if (num > max_value) {
                max_value = num;
                max_index = i + 1;
            }
        }
        sc.close();
        System.out.println(max_value);
        System.out.println(max_index);
    }
}