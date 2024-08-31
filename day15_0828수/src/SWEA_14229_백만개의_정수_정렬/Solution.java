package SWEA_14229_백만개의_정수_정렬;

import java.util.Scanner;

public class Solution {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // 퀵 정렬
        quickSort(0, arr.length - 1);
        System.out.println(arr[500000]);
    }

    // left : 정렬할 부분 배열의 시작
    // right : 정렬할 부분 배열의 끝
    static void quickSort(int left, int right) {
        if (left < right) {
            int pivotIndex = partition(left, right);
            if (pivotIndex == 500000) {
                return; // 원하는 위치를 찾았으므로 정렬을 중지
            // 피벗의 위치가 500000번째 인덱스보다 크다면
            } else if (pivotIndex > 500000) {
                quickSort(left, pivotIndex - 1); // 왼쪽 부분만 정렬
            } else {
                quickSort(pivotIndex + 1, right); // 오른쪽 부분만 정렬
            }
        }
    }
    
    // 피벗을 기준으로 두 부분으로 나눈다.
    static int partition(int left, int right) {
        int pivot = arr[right]; // 피벗을 배열의 마지막 요소로 설정
        int i = left - 1;
        for (int j = left; j < right; j++) {
        	// 현재 요소가 피벗보다 작으면
            if (arr[j] < pivot) {
                i++;
                swap(i, j); // 작은 요소를 배열의 앞부분으로 이동
            }
        }
        swap(i + 1, right);
        return i + 1; // 피벗의 최종 위치
    }

    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
