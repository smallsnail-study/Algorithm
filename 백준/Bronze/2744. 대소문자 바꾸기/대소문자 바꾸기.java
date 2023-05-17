import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if ('A'<= chars[i] && chars[i] <= 'Z')
                chars[i] = (char) (chars[i]-'A'+'a');
            else
                chars[i] = (char) (chars[i]-'a'+'A');
        }
        System.out.println(chars);
    }
}