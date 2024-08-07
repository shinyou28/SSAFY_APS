package SWEA_1224_계산기3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	for (int tc = 1; tc < 11; tc++) {
    		int length = sc.nextInt();
    		// 계산할 수식을 문자열로 입력
    		String expression = sc.next();
    		
    		// 수식을 계산한 결과를 출력
    		int result = evaluate(expression);
    		System.out.println(result);
    	}

    }

    // 중위 표기식을 계산해주는 함수
    static int evaluate(String expression) {
        // 중위 표기식을 후위 표기식으로 변환
        String postfix = infixToPostfix(expression);
        // 후위 표기식을 계산하여 결과 반환
        return evalPostfix(postfix);
    }

    // 연산자의 우선순위를 저장하는 맵
    static Map<Character, Integer> map = new HashMap<>();

    // 우선순위를 맵에 저장하는 정적 블록
    static {
        map.put('+', 1);  // 덧셈의 우선순위는 1
        map.put('-', 1);  // 뺄셈의 우선순위는 1
        map.put('*', 2);  // 곱셈의 우선순위는 2
        map.put('/', 2);  // 나눗셈의 우선순위는 2
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
            } else if (c == '(') {
                // 여는 괄호는 스택에 push
                stack.push(c);
            } else if (c == ')') {
                // 닫는 괄호는 여는 괄호가 나올 때까지 스택에서 pop하여 후위 표기식에 추가
                char popItem = stack.pop();
                while (popItem != '(') {
                    postfix += popItem;
                    popItem = stack.pop();
                }
            } else {
                // 연산자를 만났을 때
                // 스택의 최상단 연산자와 현재 연산자의 우선순위를 비교하여,
                // 우선순위가 낮은 연산자가 나올 때까지 pop하여 후위 표기식에 추가
                while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
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
                int result;

                // 연산자를 기준으로 연산 수행
                if (c == '+') {
                    result = num1 + num2;
                } else if (c == '-') {
                    result = num1 - num2;
                } else if (c == '*') {
                    result = num1 * num2;
                } else {
                    result = num1 / num2;
                }

                // 연산 결과를 스택에 push
                stack.push(result);
            }
        }

        // 최종 결과 반환
        return stack.pop();
    }
}
