import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[9];
        int totalSum = 0;
        for (int i = 0; i < 9; i++) {
            numbers[i] = sc.nextInt();
            totalSum += numbers[i];
        }
        sc.close();
        
        int sumOfFakes= totalSum - 100;
        int fake1 = -1;
        int fake2 = -1;
        boolean foundFakes = false;
        
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (numbers[i] + numbers[j] == sumOfFakes) {
                    fake1 = i;
                    fake2 = j;
                    foundFakes = true;
                    break;
                }
            }
            if (foundFakes) {
                break;
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (i != fake1 && i != fake2)
                System.out.println(numbers[i]);
        }
    }
}