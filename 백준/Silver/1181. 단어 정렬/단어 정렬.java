import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        //길이가 짧은 것부터
        //길이가 같으면 사전 순으로
        //단, 중복된 단어는 하나만 남기고 제거해야 한다.
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });

        System.out.println(words[0]);
        for (int i = 1; i < N; i++) {
            if (!words[i].equals(words[i-1]))
                System.out.println(words[i]);
        }
    }
}