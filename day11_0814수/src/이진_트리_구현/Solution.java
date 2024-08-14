package 이진_트리_구현;

public class Solution {

    // 이진 트리를 배열로 표현
    // 0번 인덱스는 사용하지 않으며, 각 노드의 자식 노드는 2 * root와 2 * root + 1 인덱스에 위치
    static char[] tree = {0, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 0, 0, 'H', 'I'};
    
    public static void main(String[] args) {
        // 전위 순회 시작
        System.out.println("전위순회");
        preorder(1); // 루트 노드부터 전위 순회 시작
        System.out.println();
        
        // 중위 순회 시작
        System.out.println("중위순회");
        inorder(1); // 루트 노드부터 중위 순회 시작
        System.out.println();
        
        // 후위 순회 시작
        System.out.println("후위순회");
        postorder(1); // 루트 노드부터 후위 순회 시작
        System.out.println();
    }
    
    // 매개변수로 트리의 루트 노드의 인덱스를 받음
    // 전위 순회: V(현재 노드) -> L(왼쪽 자식) -> R(오른쪽 자식)
    public static void preorder(int root) {
        // 루트 노드가 배열의 범위를 벗어나거나, 해당 노드가 없으면 함수 종료
        if (root >= tree.length || tree[root] == 0)
            return;
        // 현재 노드 방문(V)
        System.out.print(tree[root] + "->");
        // 왼쪽 자식 방문(L)
        preorder(root * 2);
        // 오른쪽 자식 방문(R)
        preorder(root * 2 + 1);
    }
    
    // 중위 순회: L(왼쪽 자식) -> V(현재 노드) -> R(오른쪽 자식)
    public static void inorder(int root) {
        // 루트 노드가 배열의 범위를 벗어나거나, 해당 노드가 없으면 함수 종료
        if (root >= tree.length || tree[root] == 0)
            return;
        // 왼쪽 자식 방문(L)
        inorder(root * 2);
        // 현재 노드 방문(V)
        System.out.print(tree[root] + "->");
        // 오른쪽 자식 방문(R)
        inorder(root * 2 + 1);
    }
    
    // 후위 순회: L(왼쪽 자식) -> R(오른쪽 자식) -> V(현재 노드)
    public static void postorder(int root) {
        // 루트 노드가 배열의 범위를 벗어나거나, 해당 노드가 없으면 함수 종료
        if (root >= tree.length || tree[root] == 0)
            return;
        // 왼쪽 자식 방문(L)
        postorder(root * 2);
        // 오른쪽 자식 방문(R)
        postorder(root * 2 + 1);
        // 현재 노드 방문(V)
        System.out.print(tree[root] + "->");
    }
}