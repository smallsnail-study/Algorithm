import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String str = sc.nextLine();
            if (str.equals("#"))
                break;
            
            int count = 0;
            for (char c : str.toCharArray()) {
                if (isVowel(c))
                    count++;
            }
            System.out.println(count);
        }
    }
    
    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}