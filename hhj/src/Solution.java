package src;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Map<Long, Integer> map = new HashMap<>();

        Long val1 = 1L;
        Integer val2 = 1;

        map.put(1L, 1000);

        System.out.println(Long.hashCode(1L));
        System.out.println(Integer.hashCode(1));

        System.out.println(val1.hashCode());
        System.out.println(val2.hashCode());

        //hash Map 인데 해시코드도 같은데 하나는 나오고 하나는 안나옴
        //Object 규약
        //1) equals가 같다고 판단했으면 hashcode는 무조건 같아야 한다. -> 반대는 아님
        System.out.println(map.get(val1));
        System.out.println(map.get(val2));
    }
}
