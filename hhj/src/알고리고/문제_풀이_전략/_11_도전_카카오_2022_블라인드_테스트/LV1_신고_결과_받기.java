package src.알고리고.문제_풀이_전략._11_도전_카카오_2022_블라인드_테스트;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 id_list[] : 이용자의 ID가 담긴 문자열 배열 (len=2~1_000, val=1~10, 중복 X, 알파벳 소문자)
 report[] : 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 (len=1~200_000, val=3~21, "이용자ID 신고한ID", 알파벳 소문자)
 k : 정지 기준이 되는 신고 횟수 (1~200)
 return int[] : id_list에 담긴 각 유저별 순서대로 처리 결과 메일을 받은 횟수

 1. 먼저 report의 중복을 제거 후 리스트로 관리한다.
 2. id_list를 키로 Map을 생성하여 값은 mail, report 상태를 가진 Report Class로 관리한다.
 3. 중복이 제거된 report 리스트를 기준으로 Map을 업데이트한다.
 4. 마지막으로 맵의 값인 Report가 가진 mail을 반환한다.
 */
public class LV1_신고_결과_받기 {

	public int[] solution(String[] id_list, String[] report, int k) {
		Map<String, Report> answer = new LinkedHashMap<>();
		List<String> reports = Arrays.stream(report)
			.distinct()
			.collect(Collectors.toList());

		for (String id : id_list) {
			answer.put(id, new Report());
		}

		for (String r : reports) {
			String[] ids = r.split(" ");
			answer.get(ids[1]).report(ids[0]);
		}

		for (Report r : answer.values()) {
			Set<String> ids = r.getReport();

			if (ids.size() < k) {
				continue;
			}

			for (String id : ids) {
				answer.get(id).mail();
			}
		}

		return answer.values()
			.stream()
			.mapToInt(Report::getMail)
			.toArray();
	}

	private static class Report {

		private int mail;
		private Set<String> ids;

		public Report() {
			this.mail = 0;
			this.ids = new HashSet<>();
		}

		public void report(String id) {
			ids.add(id);
		}

		public void mail() {
			mail += 1;
		}

		public Set<String> getReport() {
			return ids;
		}

		public int getMail() {
			return mail;
		}

		@Override
		public String toString() {
			return "[mail=" + mail + ", ids=" + ids + "]\n";
		}
	}
}
