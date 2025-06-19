class Solution {
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i ++) {
            // 2진 문자열로 변환
            String bnum = Long.toBinaryString(numbers[i]);
            
            // 포화 이진트리의 최소 높이 찾기
            int k = 1;
            // 2^k-1 >= bin.length() 될 때까지 증가
            while ((1<<k)-1 < bnum.length()) {
                k++;
            }
            // 포화 트리 전체 노드 수
            int fullLen = (1 << k) -1;
            
            // fullLen 길이만큼 문자열 앞에 0 채우기
            String padded = String.format("%" + fullLen + "s", bnum)
                                    .replace(' ', '0');
            
            // 유효성검사: 표현가능이면 1, 불가능이면 0
            answer[i] = isValid(padded) ? 1 : 0;
        }
        return answer;
    }
    
    private static boolean isValid(String s) {
        int len = s.length();
        int mid = len / 2; // parent 인덱스
        char parent = s.charAt(mid); // parent 값
        String left = s.substring(0, mid);
        String right = s.substring(mid+1);
        
        // 종료조건: parent가 0인데 서브트리에 1이 있으면 false
        if (parent == '0' && (left.contains("1") || right.contains("1"))) {
            return false;
        }
        
        // 리프노드인 경우
        if (len == 1) {
            return true;
        }
        
        // 재귀호출
        return isValid(left) && isValid(right);
    }
}