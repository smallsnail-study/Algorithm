import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(sc.nextLine());
        
        System.out.print(countPairs(arr, target));
        sc.close();
    }
    
    private static int countPairs(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        int count = 0;
        
        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                count++;
            }
            seen.add(num);
        }
        return count;
    }
}