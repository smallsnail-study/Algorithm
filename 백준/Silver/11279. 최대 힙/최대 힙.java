// https://www.acmicpc.net/problem/11279
// 총 N개의 정수 x가 주어질 때, x > 0 이면 배열에 추가, x=0 이면 가장 큰 값 출력(단, 배열이 비어있는 경우 0 출력)
// 시간복잡도 : O(NlogN)
// 아이디어 : 우선순위 큐(우선순위가 높은 순)
// 자료구조 : 우선순위 큐(PriorityQueue)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0)
                System.out.println(q.size() == 0 ? 0 : q.poll());
            else q.add(x);
        }
    }
}