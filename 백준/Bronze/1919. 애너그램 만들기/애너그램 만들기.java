import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        //a,b의 알파벳 개수 구하기
        int[] countA = new int[26]; // 알파벳 소문자 개수
        int[] countB = new int[26];

        for(int i = 0; i < a.length(); i++)
            countA[a.charAt(i) - 'a']++;
        for(int i = 0; i < b.length(); i++)
            countB[b.charAt(i) - 'a']++;

        int ans = 0;
        for (int i = 0; i < 26; i++)
            ans += Math.abs(countA[i] - countB[i]);
        System.out.println(ans);
    }
}