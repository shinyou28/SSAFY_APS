package SWEA_1267_작업순서;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {

            int V = sc.nextInt(); // 정점의 개수
            int E = sc.nextInt(); // 간선의 개수

            int[][] adjArr = new int[V + 1][V + 1];
            int[] degree = new int[V + 1]; // 진입 차수를 저장할 배열

            for (int i = 0; i < E; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                adjArr[A][B] = 1; // A에서 B로 가는 간선 추가
                degree[B]++; // B의 진입 차수 증가
            }

            // 진입 차수가 0인 정점을 큐에 추가합니다.
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= V; i++) {
                if (degree[i] == 0) {
                    q.add(i);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                int curr = q.poll(); // 큐에서 정점을 꺼냅니다.
                sb.append(curr).append(" "); // 현재 정점 결과에 추가

                // 현재 정점과 연결된 모든 정점을 확인
                for (int i = 1; i <= V; i++) {
                    if (adjArr[curr][i] == 1) {
                        degree[i]--; // 정점 i의 진입 차수 감소
                        if (degree[i] == 0) {
                            q.add(i); // 진입 차수가 0이 되면 큐에 추가
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + sb);

        }

    }
}
