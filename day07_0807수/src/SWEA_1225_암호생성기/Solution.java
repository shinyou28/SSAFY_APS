package SWEA_1225_암호생성기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc < 11; tc++) { // 테스트 케이스 10개
			
			int num = sc.nextInt(); // 테스트 케이스 번호
			Queue<Integer> q = new LinkedList<Integer>();
			
			for (int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());    // 8개의 수 입력				
			}
			
			out:
			while (true) {
				for (int i = 1; i <= 5; i++) {
					int front = q.poll(); // 큐에서 맨 앞의 값 빼내고
					front -= i; // i 감소하고
					if(front <= 0) front = 0; // 감소한 값이 0 이하이면 0으로 바꾸고
					q.offer(front); // 바꾼 값을 다시 뒤에 집어넣고
					if(front == 0) break out; // 그 값이 0이면 프로그램 종료
				}
			}
			
			System.out.println("#" + tc + " ");
			while(!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println(); // 하나의 테스트 케이스 끝나면 개행
					
		}
		
	}
}