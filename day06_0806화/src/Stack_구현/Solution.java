package Stack_구현;

import java.util.ArrayList;
import java.util.List;

public class Solution<T> {
    
    private List<T> stack;

    public Solution() {
        stack = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        Solution<Integer> stack = new Solution<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어있습니다.");
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어있습니다.");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
   
    public int size() {
        return stack.size();
    }
    
    

}


