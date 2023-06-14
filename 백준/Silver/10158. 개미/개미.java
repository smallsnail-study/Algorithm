import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // 첫줄에는 w와 h가 공백을 사이에 두고 주어진다.
        // 그 다음 줄에는 초기 위치의 좌표값 p와 q가 공백을 사이에 두고 주어진다.
        // 3번째 줄에는 개미가 움직일 시간 t가 주어진다.
        //출력은 t 시간 후에 개미의 위치 좌표 (x,y)의 값 x와 y를 공백을 사이에 두고 출력한다.
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();

        int currentX = (p + t) % (2 * w);
        int currentY = (q + t) % (2 * h);
        if (currentX > w)
            currentX = (2 * w) - currentX;
        if (currentY > h)
            currentY = (2 * h) - currentY;

        System.out.println(currentX + " " + currentY);
    }
}