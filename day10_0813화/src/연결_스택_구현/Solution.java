package 연결_스택_구현;

class Node<T> {
    T data;     // 데이터를 저장할 변수
    Node<T> link; // 다음 노드를 가리키는 링크
}

// 단순 연결 리스트를 사용하여 제네릭 스택 구현
class Stack<T> {
    private Node<T> head;  // 스택의 top을 가리킬 노드
    private int size;      // 스택의 크기를 나타내는 변수

    // 생성자
    Stack() {
        head = new Node<>();  // 헤드 노드를 초기화
    }

    void push(T data) {
        // 새 노드 생성 및 데이터 설정
        Node<T> newNode = new Node<>();
        newNode.data = data;

        // 새 노드를 스택의 맨 앞에 삽입
        newNode.link = head.link;
        head.link = newNode;

        size++;
    }

    T pop() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return null;
        }

        // 첫 번째 노드를 제거하고 데이터 반환
        Node<T> popNode = head.link;
        head.link = popNode.link;

        size--;

        return popNode.data;
    }

    T peek() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return null;
        }

        return head.link.data;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void printAll() {
        Node<T> curr = head.link;  // 첫 번째 데이터 노드로 이동

        while (curr != null) {  // 마지막 노드까지 순회하며 출력
            System.out.print(curr.data + " -> ");
            curr = curr.link;
        }
        System.out.println("null");
    }
}

public class Solution {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 스택에 데이터 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 스택의 모든 데이터 출력
        stack.printAll();

        // 스택에서 데이터 제거 (pop)
        System.out.println("pop: " + stack.pop());
        // 데이터 제거안하고 출력
        System.out.println("peek: " + stack.peek());

        // 스택의 모든 데이터 출력
        stack.printAll();
    }
}
