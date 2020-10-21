package kakao_2020_Blind_Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class kakao_test_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] Info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
        int[] answer = solution(Info, query);


        br.close();
        bw.close();
    }

    static public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int ans;

        for (int i = 0; i < query.length; i++) {
            String[] want = query[i].split(" and ");
            ans = 0;

            for (int j = 0; j < info.length; j++) {
                String[] str = info[j].split(" ");
                boolean chk = true;

                for (int k = 0; k < 5; k++) {
                    if (k < 3) {
                        if (!want[k].equals("-")) {
                            if (!str[k].equals(want[k])) {
                                chk = false;
                                break;
                            }
                        }
                    } else if (k == 3) {
                        if (!want[k].split(" ")[0].equals("-")) {
                            if (!info[j].split(" ")[k].equals(want[k].split(" ")[0])) {
                                chk = false;
                                break;
                            }
                        }
                    } else {
                        if (!want[3].split(" ")[1].equals("-"))
                            if (Integer.parseInt(info[j].split(" ")[k]) < Integer.parseInt(want[k - 1].split(" ")[1])) {
                                chk = false;
                                break;
                            }
                    }
                }
                if (chk)
                    ans++;

            }
            answer[i] = ans;
        }

        return answer;
    }
}
