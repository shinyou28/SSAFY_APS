package 순열_구현;

import java.util.Arrays;

public class Solution {
    static int[] nums;
    static int N;
    static boolean[] visited; // 방문 여부
    static int[] result; // 순열 결과

    public static void main(String[] args) {
        nums = new int[] { 0, 1, 2 };
        N = nums.length;
        visited = new boolean[N];
        result = new int[N];
        perm(0);
    }

    // idx : 결과 배열에 값을 저장할 현재 위치
    static void perm(int idx) {
        // 모든 자리에 숫자를 다 채웠다면
        if (idx == N) {
            System.out.println(Arrays.toString(result));
            return;
        }
        // 가능한 모든 숫자를 현재 위치에 배치
        for (int i = 0; i < N; i++) {
            // 현재 숫자가 이미 사용되었는지 확인
            if (visited[i])
                continue;
            // 사용하지 않은 숫자라면 현재 위치에 배치
            result[idx] = nums[i];
            visited[i] = true; // 방문 표시
            perm(idx + 1); // 다음 위치
            visited[i] = false; // 백트래킹
        }
    }
}