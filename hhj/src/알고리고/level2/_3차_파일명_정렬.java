package src.알고리고.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class _3차_파일명_정렬 {
    //1_000 * 3
    public static String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();

        for (String file : files) {
            StringTokenizer st = new StringTokenizer(file, "0123456789", true);

            String hb = st.nextToken();
            StringBuilder nb = new StringBuilder();
            StringBuilder tb = new StringBuilder();

            while (st.hasMoreTokens()) {
                String token = st.nextToken();

                if (!Character.isDigit(token.charAt(0))) {
                    tb.append(token);
                    break;
                }

                nb.append(token);
            }

            while (st.hasMoreTokens()) {
                tb.append(st.nextToken());
            }

            fileList.add(new File(hb, nb.toString(), tb.toString()));
        }

        Collections.sort(fileList);

        String[] answer = new String[fileList.size()];

        for (int i = 0; i < fileList.size(); i++) {
            File file = fileList.get(i);
            answer[i] = file.head + file.number + file.tail;
        }

        return answer;
    }

    static class File implements Comparable<File> {
        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            if (this.head.equalsIgnoreCase(o.head)) {
                int number1 = Integer.parseInt(this.number);
                int number2 = Integer.parseInt(o.number);

                if (number1 == number2) {
                    return 0;
                }

                return number1 - number2;
            }

            return this.head.toLowerCase()
                    .compareTo(o.head.toLowerCase());
        }
    }
}
