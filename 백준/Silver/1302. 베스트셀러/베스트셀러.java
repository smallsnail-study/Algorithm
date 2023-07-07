import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] titles = new String[N];
        for (int i = 0; i < N; i++)
            titles[i] = sc.next();

        Arrays.sort(titles); // 사전순 정렬

        String maxTitle = titles[0];
        int maxCount = 1;
        int currentCount = 1; // 현재타이틀이 몇개를 가지고 있는지
        //이전원소와 현태 타이틀이 다르면 currentCount 초기화
        for (int i = 1; i < N; i++) {
            if (!titles[i].equals(titles[i-1]))
                currentCount = 0;
            currentCount++; //연속된 책 이름이라면 2, 불연속이면 위에서 0으로 초기화했으므로 1이 된다.
            if (currentCount > maxCount || (currentCount == maxCount && titles[i].compareTo(maxTitle) < 0)) {
                maxTitle = titles[i];
                maxCount = currentCount;
            }
        }
        System.out.println(maxTitle);
    }
}