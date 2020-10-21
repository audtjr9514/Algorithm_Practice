/*
Q. 사용자의 편의를 위해서 최근 사용한 결제수단 순으로 화면에 표시하려고 합니다.
이를 위해 최근 사용한 순서대로 결제수단을 나열해주십시오.

규칙
- 내가 기억할 수 있는 결제수단은 최근 5개의 결제수단이다
- 주어진 input은 내가 사용한 순서대로 나열한 것이다.(나열된 값 중 가장 마지막 값이 사용자가 가장 최근에 사용한 결제수단이다.)
- 주어진 input을 기준으로 매 결제수단 사용시 최근 5개 결제수단을 출력하시오.

Ex_1 )
입력 : 우리 우리 우리 하나 우리 국민 삼성 농협 농협 농협 국민 저축
출력 :
 우리
 우리
 우리
 하나 우리
 우리 하나
 국민 우리 하나
 삼성 국민 우리 하나
 농협 삼성 국민 우리 하나
 농협 삼성 국민 우리 하나
 농협 삼성 국민 우리 하나
 국민 농협 삼성 우리 하나
 저축 국민 농협 삼성 우리
 */

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class tossCodingTest {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = {"우리", "우리", "우리", "하나", "우리", "국민", "삼성", "농협", " 농협", "농협", "국민", "저축"};
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (queue.isEmpty())
                queue.add(arr[i]);
            else {
                if (queue.size() < 5) {
                    if (!queue.contains(arr[i]))
                        if (queue.size() < 5)
                            queue.add(arr[i]);
                        else {
                            queue.poll();
                            queue.add(arr[i]);
                        }
                    else
                        while (queue.poll() != arr[i]) {
                            queue.add(queue.poll());
                        }
                    queue.add(queue.poll());
                }

            }
            for (int j = 0; j < queue.size(); j++) {
                bw.write(queue.peek() + " ");
                queue.add(queue.poll());
            }
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
