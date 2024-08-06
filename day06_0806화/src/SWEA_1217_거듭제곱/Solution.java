package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc < 11; tc++) { // 테스트 케이스 10개
			int num = sc.nextInt(); // 테스트 케이스의 번호
			int N = sc.nextInt();
			int M = sc.nextInt();
			int result = 1;
			for (int i = 0; i < M; i++) {
				result *= N;
			}
			
			System.out.println("#" + num + " " + result);
			
			
		}
		
		
	}
}
