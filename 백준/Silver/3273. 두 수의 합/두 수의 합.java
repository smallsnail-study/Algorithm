import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.print(countPairs(arr, target));
    }
    
    private static int countPairs(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        int count = 0;
        
        for(int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                count++;
            }
            seen.add(num);
        }
        return count;
    }
}