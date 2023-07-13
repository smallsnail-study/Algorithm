import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //첫째 줄에 단어의 개수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());
        //둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {  // O(N)
            words[i] = br.readLine();
        }

        //조건에 따라 정렬하는 프로그램을 작성하시오.
        //1. 길이가 짧은 것부터
        //2. 길이가 같으면 사전 순으로
        Arrays.sort(words, new Comparator<String>() { // O(N log N)
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });
        //단, 중복된 단어는 하나만 남기고 제거해야 한다.
        System.out.println(words[0]);
        for (int i = 1; i < N; i++) { // O(N)
            if (!words[i].equals(words[i-1]))
                System.out.println(words[i]);
        }
    }
}

// 시간복잡도 : O(N log N)
// 아이디어 : Arrays.sort(), Comparator<>(), compare()
// 자료구조 : 문자열, 정렬