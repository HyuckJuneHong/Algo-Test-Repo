package src.문제_풀이_전략._11_도전_카카오_2022_블라인드_테스트;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
fees[]: 주차 요금을 나타내는 정수 배열 (len=4, val=[기본시간(분), 기본요금(원), 단위시간(분), 단위요금(원)])
records[]: 자동차 입/출차 내역을 나타내는 문자열 배열 (len=1~1_000, val="HH:MM 차랑변호 IN/OUT")
return : 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 반환
*/
public class Lv2_주차_요금_계산 {

	public int[] solution(int[] fees, String[] records) {
		List<Integer> answer = new ArrayList<>();
		Map<String, Integer> times = new TreeMap<>();
		Map<String, Integer> cars = new HashMap<>();

		for (String record : records) {
			String[] infos = record.split(" ");
			String[] time = infos[0].split(":");

			int minutes = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
			String number = infos[1];
			String type = infos[2];

			if (type.equals("IN")) {
				cars.put(number, minutes);
				continue;
			}

			int parkingTime = minutes - cars.get(number);

			times.put(number, times.getOrDefault(number, 0) + parkingTime);
			cars.remove(number);
		}

		int minutes = 23 * 60 + 59;

		for (String number : cars.keySet()) {
			int parkingTime = minutes - cars.get(number);

			times.put(number, times.getOrDefault(number, 0) + parkingTime);
		}

		for (String number : times.keySet()) {
			int time = times.get(number);
			int cost = fees[1];

			if (time > fees[0]) {
				time -= fees[0];
				cost += (int)(Math.ceil((double)time / (double)fees[2]) * fees[3]);
			}

			answer.add(cost);
		}

		return answer.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
