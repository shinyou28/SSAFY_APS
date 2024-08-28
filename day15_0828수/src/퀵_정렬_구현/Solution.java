package 퀵_정렬_구현;

import java.util.Arrays;

// 호어 파티션
public class Solution {
	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length;
	
	public static void main(String[] args) {
		quickSort(0, N - 1);
		System.out.println();
	}
	
	// 퀵 정렬 함수
	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			// 피벗 왼쪽 구간 정렬
			quickSort(left, pivot - 1);
			// 피벗 오른쪽 구간 정렬
			quickSort(pivot + 1, right);
		}
	}
	
	// 파티션 함수
	private static int partition(int left, int right) {
		int pivot = arr[left]; // 피봇을 구간의 첫 번째 요소로 설정
		
		int L = left + 1; // 왼쪽 포인터는 피봇 다음 요소
		int R = right; // 오른쪽 포인터는 구간의 끝 요소
		
		while (L <= R) {
			// L : 피봇보다 큰 값을 찾을 때까지 오른쪽으로 이동
			while (L <= R && arr[L] <= pivot)
				L++;
			// R : 피봇보다 작거나 큰 값을 찾을 때까지 왼쪽으로 이동
			while(arr[R] > pivot)
				R--;
			// L과 R이 교차하지 않는 경우, 두 값을 교환
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		return R;
		
	}
}
