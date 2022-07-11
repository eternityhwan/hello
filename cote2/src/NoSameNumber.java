import java.util.*;

public class NoSameNumber {
    public int[] solution() {
        int[] arr = {1, 1, 3, 3, 0, 1, 1}; // 들어갈 값 총 7개
        ArrayList<Integer> temp = new ArrayList<>(); // 연속 숫자를 제거한 배열 받을 것
        int[] answer = {}; // 결과를 출력할 배열
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                temp.add(i);
            }
        }
        return answer; // { 1 3 0 1} 이렇게 나오면 된다.
    }

    public static void main(String[] args) {
        NoSameNumber noSameNumber = new NoSameNumber();
        noSameNumber.solution();
        System.out.println(noSameNumber.solution());
    }
}