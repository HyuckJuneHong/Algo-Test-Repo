package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _6일차 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        List<Part> parts = generateParts(N, S);
        Map<String, Integer> P = sortParts(parts);
        int answer = getMaxScore(parts, P);

        System.out.println(answer);
    }

    private static int getMaxScore(List<Part> parts, Map<String, Integer> P) {
        int maxScore = 0;

        for (Part p : parts) {
            int current = P.get(p.p1) + P.get(p.p2) + P.get(p.p3);

            if (maxScore < current) {
                maxScore = current;
            }
        }

        return maxScore;
    }

    private static Map<String, Integer> sortParts(List<Part> parts) {
        List<String> listP = parts.stream()
                .flatMap(part -> Stream.of(part.p1, part.p2, part.p3))
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        Map<String, Integer> mapP = new HashMap<>();

        for (int i = 0; i < listP.size(); i++) {
            mapP.put(listP.get(i), i + 1);
        }

        return mapP;
    }

    private static List<Part> generateParts(int N, String S) {
        List<Part> parts = new ArrayList();

        for (int i = 1; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                String p1 = S.substring(0, i);
                String p2 = S.substring(i, j);
                String p3 = S.substring(j);

                parts.add(new Part(p1, p2, p3));
            }
        }

        return parts;
    }

    static class Part {
        String p1;
        String p2;
        String p3;

        Part(String p1, String p2, String p3) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
        }
    }
}
