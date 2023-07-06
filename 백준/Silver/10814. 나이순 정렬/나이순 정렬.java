import java.util.Arrays;
import java.util.Scanner;

class Main {
    static class Member implements Comparable<Member>{
        int age;
        String name;
        int idx;

        Member(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }

        @Override
        public int compareTo(Member o) {
            if (age != o.age)
                return age - o.age;
            return idx - o.idx;
        }
        // 1. 나이가 적은 회원 먼저
        // 2. 나이가 같으면 먼저 가입한 사람 먼저
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Member[] members = new Member[N];
        for (int i = 0; i < N; i++) {
            members[i] = new Member(sc.nextInt(), sc.next(), i);
        }

        Arrays.sort(members);

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }
}