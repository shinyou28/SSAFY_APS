package SWEA_1222_계산기1;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	for (int tc = 1; tc < 11; tc++) {
    		// 계산식 길이 입력
    		int length = sc.nextInt();
    		// 계산할 수식을 문자열로 입력
    		String expression = sc.next();
    		
    		// 수식을 계산한 결과를 출력
    		int result = evaluate(expression);
    		System.out.println("#" + tc + " " + result);
    		
    	}
    }

    // 중위 표기식을 계산해주는 함수
    static int evaluate(String expression) {
        // 중위 표기식을 후위 표기식으로 변환
        String postfix = infixToPostfix(expression);
        // 후위 표기식을 계산하여 결과 반환
        return evalPostfix(postfix);
    }


    // 1. 중위 표기식을 후위 표기식으로 변환해주는 함수
    static String infixToPostfix(String infix) {
        String postfix = "";              // 후위 표기식을 저장할 문자열
        Stack<Character> stack = new Stack<>(); // 연산자를 저장할 스택

        // 중위 표기식의 각 문자를 순회
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if ('0' <= c && c <= '9') {
                // 피연산자가 나오면 바로 후위 표기식에 추가
                postfix += c;

            } else {
                // 연산자를 만났을 때
                while (!stack.isEmpty()) {
                    char popItem = stack.pop();
                    postfix += popItem;
                }
                // 현재 연산자를 스택에 push
                stack.push(c);
            }
        }

        // 스택에 남아 있는 모든 연산자를 pop하여 후위 표기식에 추가
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;
    }

    // 2. 후위 표기식을 계산해주는 함수
    static int evalPostfix(String postfix) {
        Stack<Integer> stack = new Stack<>(); // 피연산자를 저장할 스택

        // 후위 표기식의 각 문자를 순회
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if ('0' <= c && c <= '9') {
                // 피연산자는 스택에 push
                stack.push(c - '0');
            } else {
                // 연산자를 만나면 스택에서 두 개의 피연산자를 pop하여 연산 수행
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = 0;

                // 연산자를 기준으로 연산 수행
                if (c == '+') result = num1 + num2;

                // 연산 결과를 스택에 push
                stack.push(result);
            }
        }
        // 최종 결과 반환
        return stack.pop();
    }
}
