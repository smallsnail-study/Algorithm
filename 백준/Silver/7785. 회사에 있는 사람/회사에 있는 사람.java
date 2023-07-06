import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Set<String> set = new TreeSet<>(); // 사전역순으로 출력해야 하기 때문에 순서를 가지는 Treeset으로 설정
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            String status = sc.next();
            if (status.equals("enter"))
                set.add(name); // 집합에 추가
            else set.remove(name);// 집합에서 제거
        }

        String[] orderedName = set.toArray(new String[set.size()]);
        for (int i = orderedName.length - 1; i >= 0; i--) {
            System.out.println(orderedName[i]);
        }
    }
}