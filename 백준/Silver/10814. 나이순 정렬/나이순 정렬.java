import java.util.Arrays;
import java.util.Scanner;

class Main {
    static class Member implements Comparable<Member>{
        int age;
        String name;
        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
                return age - o.age;
        }
        // 1. 나이가 적은 회원 먼저
        // 2. 나이가 같으면 먼저 가입한 사람 먼저
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Member[] members = new Member[N];
        for (int i = 0; i < N; i++) {
            members[i] = new Member(sc.nextInt(), sc.next());
        }

        Arrays.sort(members);

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }
}