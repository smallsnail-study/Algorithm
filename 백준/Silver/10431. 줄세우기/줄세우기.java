import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        //첫 줄에 테스트 케이스의 수 P (1 ≤ P ≤ 1000) 가 주어진다.
        //각 테스트 케이스는 테스트 케이스 번호 T와 20개의 양의 정수가 공백으로 구분되어 주어진다.
        //20개의 정수는 줄서기를 할 아이들의 키를 줄서기 차례의 순서대로 밀리미터 단위로 나타낸 것이다.
        //모든 테스트 케이스는 독립적이다.
        //각각의 테스트 케이스에 대해 테스트 케이스의 번호와 학생들이 뒤로 물러난 걸음 수의 총합을 공백으로 구분하여 출력한다.
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int[] h = new int[20];

        while (P-- > 0) {
            int T = sc.nextInt();
            for (int i = 0; i < 20; i++) {
                h[i] = sc.nextInt();
            }

            int cnt = 0;
            int[] sorted = new int[20];
            for (int i = 0; i < 20; i++) {
                boolean find = false;
                for (int j = 0; j < i; j++) {
                    if (sorted[j] > h[i]) {
                        find = true;
                        for (int k = i-1; k >= j ; k--) {
                            sorted[k+1] = sorted[k];
                            cnt++;
                        }
                        sorted[j] = h[i];
                        break;
                    }
                }
                if (!find) sorted[i] = h[i];
            }
            System.out.println(T + " " + cnt);
        }
    }
}