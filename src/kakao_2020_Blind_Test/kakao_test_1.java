package kakao_2020_Blind_Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class kakao_test_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = "\"...!@BaT#*..y.abcdefghijklm\"";
        String str2 = "\"z-+.^.\"";
        String str3 = "\"=.=\"";
        String str4 = "\t\"123_.def\"";
        String str5 = "\"abcdefghijklmn.p\"";

        solution(str1);
        solution(str2);
        solution(str3);
        solution(str4);
        solution(str5);
        br.close();
        bw.close();
    }

    static String check(String new_id) {
        if (new_id.charAt(0) == '.')
            new_id = new_id.substring(1);
        if (new_id.length() != 0)
            if (new_id.charAt(new_id.length() - 1) == '.')
                new_id = new_id.substring(0, new_id.length() - 1);
        return new_id;

    }

    static public String solution(String new_id) {
        new_id = new_id.replace("\"", "").toLowerCase();
        char[] str = new char[new_id.length()];


        String answer = "";
        for (int i = 0; i < str.length; i++) {
            str[i] = new_id.charAt(i);
            // 2단계 : 문자 제외한 모든 문자 제거
            if ((str[i] >= 48 && str[i] <= 57) ||
                    (str[i] >= 97 && str[i] <= 122) || str[i] == '-' || str[i] == '_' || str[i] == '.')
                answer = answer.concat(Character.toString(str[i]));

        }
        new_id = "";
        int chk = 1;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == '.') {
                if (chk == 1) {
                    chk++;
                    new_id = new_id.concat(Character.toString(answer.charAt(i)));
                } else
                    chk++;
            } else {
                chk = 1;
                new_id = new_id.concat(Character.toString(answer.charAt(i)));
            }
        }

        new_id = check(new_id);

        if (new_id.length() < 1)
            new_id = "a";
        if (new_id.length() >= 16)
            new_id = new_id.substring(0, 15);
        new_id = check(new_id);

        answer = new_id;
        if (new_id.length() <= 2) {
            while (answer.length() < 3) {
                answer = answer.concat(Character.toString(new_id.charAt(new_id.length() - 1)));
            }

        }

        System.out.println(answer);
        return answer;
    }
}
