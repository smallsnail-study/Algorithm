import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[][] records = new String[N][2];
        for (int i = 0; i < N; i++) {
            records[i][0] = sc.next(); // 사원 이름
            records[i][1] = sc.next(); // enter,leave
        }

        // 1. 이름 순서에 따라 출입기록을 차례로 정렬한다.
        Arrays.sort(records, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                // 역순 정렬을 위해 o1이 아닌 o2를 비교
                return o2[0].compareTo(o1[0]);
            }
        });

        // 2. 각 사원마다 마지막 기록이 enter라면, 출력한다. (사전 역순)
        for (int i = 0; i < N - 1; i++)
            // 이름에 대한 마지막 기록을 확인하기 위해 이름이 마지막 기록이 아니면서, enter인 경우
            // -> 현재 회사에 남아있는 사람이므로 이름출력
            if (!records[i][0].equals(records[i + 1][0]) && records[i][1].equals("enter"))
                System.out.println(records[i][0]);

        // 위의 반복문에서는 N-2까지만 확인하므로 마지막값에 대해 별도로 확인해줘야 한다.
        // 마지막에 입력된 값에 대해 현재 회사에 남아있는 사람인지 확인하기
        if (records[N-1][1].equals("enter"))
            System.out.println(records[N - 1][0]);
    }
}