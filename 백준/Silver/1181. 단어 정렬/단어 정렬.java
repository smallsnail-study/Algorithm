import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }
        // 1. 길이가 짧은 것부터
        // 2. 길이가 같으면 사전 순으로
//        Arrays.sort(words, new Comparator<String>() { // 원하는 조건으로 정렬하기 위해 Comparator
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.length() == o2.length())
//                    return o1.compareTo(o2); // o1에 대해 o2가 사전순으로 빠른지 뒤인지 확인
//                return o1.length() - o2.length();
//            }
//        });
        // 위의 자동완성되는 부분을 아래처럼 람다로 간단핟게 할 수 있다.(자동완성기능 제공 안될 시 사용해보기)
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2); // o1에 대해 o2가 사전순으로 빠른지 뒤인지 확인
            return o1.length() - o2.length();
        });

        // 중복된 단어는 하나만 남기고 제거해야 한다.
        System.out.println(words[0]);
        for (int i = 1; i < N; i++) {
            if (!words[i].equals(words[i - 1]))
                System.out.println(words[i]);
        }
    }
}