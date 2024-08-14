package 연결_큐_구현;

//노드 클래스 정의 (제네릭 타입 사용)
class Node<T> {
 T data;        // 데이터를 저장할 변수
 Node<T> link;  // 다음 노드를 가리키는 링크
}

//단순 연결 리스트를 사용하여 제네릭 큐 구현
class Queue<T> {
 private Node<T> front;  // 큐의 맨 앞을 가리킬 노드
 private Node<T> rear;   // 큐의 맨 뒤를 가리킬 노드
 private int size;       // 큐의 크기를 나타내는 변수

 // 생성자
 Queue() {
     front = null;
     rear = null;
     size = 0;
 }

 // 큐에 데이터를 추가 (enqueue 연산)
 void enqueue(T data) {
     Node<T> newNode = new Node<>();
     newNode.data = data;

     if (isEmpty()) {
         front = newNode;  // 큐가 비어있으면 front와 rear가 새 노드를 가리킴
         rear = newNode;
     } else {
         rear.link = newNode;  // 기존의 rear 노드에 새 노드를 연결하고 rear 갱신
         rear = newNode;
     }

     size++;
 }

 // 큐에서 데이터를 제거하고 반환 (dequeue 연산)
 T dequeue() {
     if (isEmpty()) {
         System.out.println("큐가 비어있습니다.");
         return null;
     }

     T data = front.data;
     front = front.link;

     if (front == null) {  // 큐가 비어있으면 rear도 null로 설정
         rear = null;
     }

     size--;
     return data;
 }

 // 큐의 맨 앞 데이터를 반환 (삭제하지 않음, peek 연산)
 T peek() {
     if (isEmpty()) {
         System.out.println("큐가 비어있습니다.");
         return null;
     }

     return front.data;
 }

 // 큐가 비어있는지 확인
 boolean isEmpty() {
     return size == 0;
 }

 // 큐의 크기 반환
 int size() {
     return size;
 }

 // 큐의 모든 데이터를 출력 (디버깅용)
 void printAll() {
     Node<T> curr = front;  // 첫 번째 데이터 노드로 이동

     while (curr != null) {  // 마지막 노드까지 순회하며 출력
         System.out.print(curr.data + " -> ");
         curr = curr.link;
     }
     System.out.println("null");
 }
}

//테스트를 위한 메인 클래스
public class Solution {
 public static void main(String[] args) {
     Queue<Integer> queue = new Queue<>();

     // 큐에 데이터 추가
     queue.enqueue(1);
     queue.enqueue(2);
     queue.enqueue(3);

     // 큐의 모든 데이터 출력
     queue.printAll();

     System.out.println("dequeue: " + queue.dequeue());
     System.out.println("peek: " + queue.peek());

     // 큐의 모든 데이터 출력
     queue.printAll();
 }
}
