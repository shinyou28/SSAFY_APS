import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 수
		int T = sc.nextInt(); 
		for (int tc = 1; tc <= T; tc++) {
			char[][] arr = new char[5][15];
			// 배열을 공백으로 초기화
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 15; j++) {
					arr[i][j] = ' ';
				}
			}
			// 배열에 들어갈 단어 입력
			for (int i = 0; i < 5; i++) {
				String word = sc.next();
				for (int j = 0; j < word.length(); j++) {
					arr[i][j] = word.charAt(j);
				}
			}
			// 열과 행을 바꿔서 출력
			System.out.print("#" + tc + " ");
			for (int j = 0; j < 15; j++) {
				for (int i = 0; i < 5; i++) {
					if(arr[i][j] != ' ') {
						System.out.print(arr[i][j]);
					}
				}
			}
			System.out.println();
			
		}
		
	}
}
