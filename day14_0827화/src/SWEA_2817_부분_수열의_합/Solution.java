package SWEA_2817_부분_수열의_합;

import java.util.Scanner;

public class Solution {
	static int N; // 배열의 크기
	static int K; // 원하는 합
	static int[] A; // 주어진 숫자 배열
	static int count; // 유효한 조합의 개수
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
        	
        	N = sc.nextInt();
        	K = sc.nextInt();
        	
        	A = new int[N];
        	
        	for(int i = 0; i < N; i++) {
        		A[i] = sc.nextInt();
        	}
        	
        	count = 0;
        	
        	for(int r = 1; r <= N; r++) {
        		comb(r, 0, 0, 0);
        	}
        	
        	System.out.println("#" + tc + " " + count);
        	
        }
        
    }
    
    public static void comb(int R, int idx, int sidx, int sum) {
        if(sidx == R) {
        	// 선택된 요소들의 합이 K인지 확인
        	if(sum == K) {
        		count++;
        	}
        	return;
        }
        
        // 배열의 끝에 도달하면 리턴
        if(idx >= N) {
        	return;
        }
        
        // 현재 요소를 포함하는 경우
        comb(R, idx + 1, sidx + 1, sum + A[idx]);
        // 현재 요소를 포함하지 않는 경우
        comb(R, idx + 1, sidx, sum);
    }
}
