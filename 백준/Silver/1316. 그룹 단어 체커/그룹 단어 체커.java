import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            String word = sc.next();
            if (isGroupWord(word))
                count++;
        }
        sc.close();
        System.out.print(count);
    }
    
    private static boolean isGroupWord(String word) {
        char prev = word.charAt(0);
        Set<Character> before = new HashSet<>();
        boolean isGroup = true;
        
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (prev != cur)
                before.add(prev);
            if (before.contains(cur)) {
                isGroup = false;
                break;
            }
            prev = cur;
        }
        return isGroup;
    }
}