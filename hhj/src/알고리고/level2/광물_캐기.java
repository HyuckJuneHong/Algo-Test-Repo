package src.알고리고.level2;

import java.util.*;

public class 광물_캐기 {

    static Map<String, Integer> iron = new HashMap<>();
    static Map<String, Integer> stone = new HashMap<>();
    static List<Mineral> list = new ArrayList<>();
    static int dp = 0, ip = 0, sp = 0;

    public int solution(
            int[] picks,        // 곡괭이 갯수 [dia, iron stone] (0~5)
            String[] minerals   // 광물들 순서 (5~50)
    ) {                         // return : 작업 끝나기 전까지 필요한 최소 피로도
        init(picks, minerals);
        Collections.sort(list);
        int answer = 0;

        for (int i = 0; i < list.size(); i++) {
            String[] mineral = list.get(i).mineral;

            if (dp > 0) {
                answer += mineral.length;
                dp--;
                continue;
            }

            if (ip > 0) {
                for (String m : mineral) {
                    answer += iron.get(m);
                }

                ip--;
                continue;
            }

            if (sp > 0) {
                for (String m : mineral) {
                    answer += stone.get(m);
                }

                sp--;
            }
        }

        return answer;
    }

    public void init(int[] picks, String[] minerals) {
        dp = picks[0];
        ip = picks[1];
        sp = picks[2];
        iron.put("diamond", 5);
        iron.put("iron", 1);
        iron.put("stone", 1);
        stone.put("diamond", 25);
        stone.put("iron", 5);
        stone.put("stone", 1);

        int size = (int) Math.ceil(minerals.length / 5.0);
        int[] fatigue = new int[size];
        int index = 0;

        if ((dp + ip + sp) * 5 < minerals.length) {
            minerals = Arrays.copyOf(minerals, (dp + ip + sp) * 5);
        }

        for (int i = 0; i < minerals.length; i++) {
            if (i % 5 == 0 && i != 0) {
                index++;
            }

            fatigue[index] += stone.get(minerals[i]);

            if ((i + 1) % 5 == 0 || i == minerals.length - 1) {
                String[] mineral = Arrays.copyOfRange(minerals, index * 5, i + 1);
                list.add(new Mineral(mineral, fatigue[index]));
            }
        }
    }

    public static class Mineral implements Comparable<Mineral> {
        String[] mineral;
        int fatigue;

        public Mineral(String[] mineral, int fatigue) {
            this.mineral = mineral.clone();
            this.fatigue = fatigue;
        }

        @Override
        public int compareTo(Mineral o) {
            return o.fatigue - this.fatigue;
        }

        @Override
        public String toString() {
            return "\n[" + Arrays.toString(mineral) + ", " + fatigue + "]";
        }
    }
}
