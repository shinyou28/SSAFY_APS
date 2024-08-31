package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			sc.nextInt(); // 테스트 케이스 번호 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int result = pow(N, M);
			System.out.println("#" + tc + " " + result);
		}
	}
	public static int pow(int N, int M) {
		if(M == 0) {
			return 1;
		}
		// 문제를 더 작은 문제로 나눈다.
		int halfPow = pow(N, M / 2);
		// M이 짝수일 경우, halfPow의 제곱
		if(M % 2 == 0) {
			return halfPow * halfPow;
		}
		// M이 홀수일 경우, halfPow의 제곱에 N을 곱한 것
		else {
			return halfPow * halfPow * N;
		}
	}
}
