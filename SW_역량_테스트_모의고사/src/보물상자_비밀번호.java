import java.util.*;
 
public class 보물상자_비밀번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수 입력
 
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 숫자의 길이 입력
            int K = sc.nextInt(); // 찾고자 하는 순위 입력
             
            int rotate = N / 4; // 한 변의 길이 (회전할 때 자를 부분의 길이)
            String num = sc.next(); // 16진수 문자열 입력
            // 중복 되지 않은 16진수 문자열 저장
            Set<String> uniqueNumber = new HashSet<>();
            // 회전 진행
            for (int r = 0; r < rotate; r++) {
 
                for (int i = 0; i < 4; i++) {
                    String part = num.substring(i*rotate, (i+1)*rotate);
                    uniqueNumber.add(part);
                }
 
                // 문자열을 시계 방향으로 회전
                num = num.charAt(N-1) + num.substring(0, N-1);
                 
            }
 
            // set에 있는 16진수를 10진수로 변경
            List<Integer> sortedNumber = new ArrayList<>();
            for(String s : uniqueNumber) {
                sortedNumber.add(Integer.parseInt(s, 16));
            }
 
            Collections.sort(sortedNumber, Collections.reverseOrder());
 
            System.out.println("#" + tc + " " + sortedNumber.get(K-1));
             
        }
 
    }
}
