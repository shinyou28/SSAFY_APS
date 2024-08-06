package SWEA_8931_제로;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스의 수
        int T = sc.nextInt();
        
        for (int tc = 0; tc < T; tc++) {
        	
        	// 입력받을 정수의 갯수
        	int K = sc.nextInt();
        	
        	Stack<Integer> stack = new Stack<>();
        	
        	for (int i = 0; i < K; i++) {
        		int num = sc.nextInt();
        		
        		if (num == 0) stack.pop();
        		else stack.push(num);
        	}
        	
        	int sum = 0;
        	while(!stack.isEmpty()) {
        		sum += stack.pop();
        	}
        	
        	System.out.println("#" + (tc + 1) + " " + sum);
        }   
        
    }
}