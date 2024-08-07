package Queue_구현;

import java.util.LinkedList;

public class Solution<T> {

    private LinkedList<T> queue;
    private int rear;     // 가장 나중에 들어온 노드
    private int front;    // 가장 먼저 들어온 노드

    public Solution() {
        queue = new LinkedList<>();
        rear = 0;
        front = 0; // 처음에는 rear와 front가 같은 위치에서 시작
    }

    public static void main(String[] args) {
        Solution<Integer> queue = new Solution<>();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        System.out.println(queue.deQueue());
        System.out.println(queue.Qpeek());
        System.out.println(queue.size());
    }
    // 큐가 비어있는 경우 노드가 존재하지 않기에 front와 rear 모두 null을 가리키고 있다.
    public boolean isEmpty() {
        return front == rear;
    }
    // 뒤에서 삽입
    public void enQueue(T item) {
        queue.add(item);
        rear++;
    }
    // 맨 앞에 있는 값 삭제
    public T deQueue() {
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비었습니다.");
        }
        T item = queue.remove(front);
        rear--;
        return item;
    }
    
    public T Qpeek() {
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비었습니다.");
        }
        return queue.get(front);
    }

    public int size() {
        return rear - front;
    }
}
