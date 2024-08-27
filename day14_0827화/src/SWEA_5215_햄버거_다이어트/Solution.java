package SWEA_5215_햄버거_다이어트;

import java.util.Scanner;

public class Solution {
	
	static int N; // 재료의 수
	static int L; // 제한 칼로리
	static int[][] burger; // 재료별 점수와 칼로리 배열
	static int maxScore; // 점수가 가장 높은 햄버거의 점수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			burger = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				burger[i][0] = sc.nextInt(); // 점수
				burger[i][1] = sc.nextInt(); // 칼로리
			}
			
			maxScore = 0; // 최대 점수 초기화
			
			comb(0, 0, 0);
			
			System.out.println("#" + tc + " " + maxScore);
		}
		
	}
	
	public static void comb(int idx, int totalScore, int totalCalories) {
		// 제한 칼로리를 초과하면 리턴
		if(L < totalCalories) {
			return;
		}
		// 모든 재료를 확인한 경우
		if(idx == N) {
			if(maxScore < totalScore) {
				maxScore = totalScore;
			}
			return;
		}
		
		// 현재 재료를 포함하는 경우
		comb(idx + 1, totalScore + burger[idx][0], totalCalories + burger[idx][1]);
		// 현재 재료를 포함하지 않는 경우
		comb(idx + 1, totalScore, totalCalories);
	}
	
	
}
