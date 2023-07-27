package src.알고리고.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class _3차_파일명_정렬 {
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String current = files[i];
            StringTokenizer st = new StringTokenizer(current, "0123456789", true);
            String head = st.nextToken();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();

            while (st.hasMoreTokens()) {
                String next = st.nextToken();

                if (!Character.isDigit(next.charAt(0))) {
                    tail.append(next);
                    break;
                }

                number.append(next);
            }

            while (st.hasMoreTokens()) {
                tail.append(st.nextToken());
            }

            list.add(new File(head, number.toString(), tail.toString()));
        }

        Collections.sort(list);
        String[] answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            File file = list.get(i);
            answer[i] = file.head + file.number + file.tail;
        }

        return answer;
    }

    public class File implements Comparable<File> {
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
            String head1 = this.head.toLowerCase();
            String head2 = o.head.toLowerCase();

            if (head1.equals(head2)) {
                int number1 = Integer.parseInt(this.number);
                int number2 = Integer.parseInt(o.number);
                return number1 - number2;
            }

            return head1.compareTo(head2);
        }
    }
}
