import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String origin = sc.next();
        List<Character> list = new LinkedList<>();
        // 비어있는 list에 origin 한글자씩 넣어주기
        for (char alp : origin.toCharArray())
            list.add(alp);

        int M = sc.nextInt(); // 명령어

        //ListIterator 인터페이스는 컬렉션 요소의 대체, 추가 그리고 인덱스 검색 등을 위한 작업에서 양방향으로 이동하는 것을 지원
        // 특정 인덱스의 위치를 가지는 iterator 생성 가능
        ListIterator<Character> it = list.listIterator(list.size()); // 제일 뒤에 있는 상태로 커서가 위치
        while (M-- > 0) {
            char cmd = sc.next().charAt(0);
            if (cmd == 'L') {
                // L : 커서를 왼쪽으로 옮긴다. 맨 앞이면 무시된다.
                if (it.hasPrevious())
                    it.previous();
            }
            else if (cmd == 'D') {
                // D : 커서를 오른쪽으로 옮긴다. 맨 뒤면 무시된다.
                if (it.hasNext())
                    it.next();
            }
            else if (cmd == 'B') {
                // B : 커서 왼쪽의 문자를 삭제한다. 맨 앞이면 무시된다.
                // listIterator의 remove는 반환된 가장 마지막 요소(lastReturned)를 리스트에서 제거함.
                // 커서 왼쪽의 문자를 lastReturned로 만들어준다. -> 커서를 왼쪽으로 한칸 이동해준다
                if (it.hasPrevious()) {
                    it.previous(); // 커서를 왼쪽으로 한칸 이동해준다
                    it.remove();
                }
            }
            else if (cmd == 'P') {
                // P x : 입력받은 문자를 커서 왼쪽에 추가한다.
                it.add(sc.next().charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char alp : list)
            sb.append(alp);
        System.out.print(sb);
    }
}

// 시간복잡도 : O(M)
// 아이디어 : ListIterator 활용
// 자료구조 : LinkedList