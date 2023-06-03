import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26]; // 영문자 총 26개의 배열
        String str = sc.next();   // 입력받을 문자열

        for (int i = 0; i < str.length(); i++) {        // 입력받은 문자열 첫번째문자부터 마지막문자까지 검사
            if (65<= str.charAt(i) && str.charAt(i) <= 90){   // 아스키코드 대문자 범위, str.charAt() 문자열에서 특정인덱스에 위치하는 유니코드 단일문자반환
                arr[str.charAt(i) - 65]++;      //대문자범위(65~90)-65=배열 인덱스 값   ex)arr[0]=a,arr[1]=b,....
            } else {
                arr[str.charAt(i) - 97]++;     //소문자범위(97~122)-97=배열 인덱스 값
            }
        }
        int max=0;         //최댓값 저장 변수 설정
        char ch='?';       //출력할 문자 변수 설정

        for (int i = 0; i < 26; i++) {           //배열 순회 반복문
            if (arr[i] > max){          // 배열값이 최댓값보다 큰 경우
                max = arr[i];          // 최댓값에 배열값을 저장
                ch = (char)(i+65);     // 문자로 변환(대문자로 출력해야하기 때문에 +65)
            } else if (arr[i]==max) {  // 배열값이 최댓값이랑 같을 경우
                ch = '?';              // 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
            }
        }
        System.out.println(ch);
    }
}