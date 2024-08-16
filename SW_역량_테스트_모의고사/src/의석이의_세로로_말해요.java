import java.util.Scanner;
 
public class 의석이의_세로로_말해요 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt(); // 테스트 케이스 수
         
        for (int tc = 1; tc <= T; tc++) {
            // 최대 15x15 크기의 2차원 배열 생성
            char[][] arr = new char[15][15];
             
            // 배열을 공백 문자로 초기화
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    arr[i][j] = ' ';
                }
            }
             
            // 5개의 단어 입력 및 배열에 저장
            for (int i = 0; i < 5; i++) {
                String word = sc.next();
                for (int j = 0; j < word.length(); j++) {
                    arr[i][j] = word.charAt(j);
                }
            }
             
            // 세로로 출력
            System.out.print("#" + tc + " ");
            for (int j = 0; j < 15; j++) {
                for (int i = 0; i < 5; i++) {
                    // 빈 칸은 출력하지 않음
                    if (arr[i][j] != ' ') {
                        System.out.print(arr[i][j]);
                    }
                }
            }
            System.out.println();
        }
    }
}