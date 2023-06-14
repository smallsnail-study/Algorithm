import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();

        int timeX = t % (2 * w);
        int currentX = p;
        int deltaX = 1;

        while (timeX-- > 0) {
            if (currentX == w)
                deltaX = -1;
            else if (currentX == 0)
                deltaX = 1;
            currentX += deltaX;
        }

        int timeY = t % (2 * h);
        int currentY = q;
        int deltaY = 1;

        while (timeY-- > 0) {
            if (currentY == h)
                deltaY = -1;
            else if (currentY == 0)
                deltaY = 1;
            currentY += deltaY;
        }

        System.out.println(currentX + " " + currentY);
    }
}