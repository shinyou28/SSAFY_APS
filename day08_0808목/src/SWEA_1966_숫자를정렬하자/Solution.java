package SWEA_1966_숫자를정렬하자;

import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수
		for (int tc = 1; tc < 11; tc++) {
			int N = sc.nextInt();  // 숫자열 길이
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt(); // 숫자 입력
			}
			
			for (int i = 0; i < arr.length; i++) {
				int tmp = arr[i]; // 선택 데이터
				int j = i - 1; // 비교할 데이터
				// 비교할 데이터가 선택한 데이터보다 크다면, j가 0보다 클 때까지 반복해서 비교
				while (j >= 0 && arr[j] >= tmp) {
					// 비교할 데이터를 한칸 뒤로 보낸다.
					arr[j + 1] = arr[j]; 
					j--;
				}
				arr[j + 1] = tmp; // 비교할 데이터가 선택한 데이터보다 작다면 그대로 둔다.
			}
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}