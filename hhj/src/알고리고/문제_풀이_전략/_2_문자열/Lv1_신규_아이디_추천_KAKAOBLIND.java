package src.알고리고.문제_풀이_전략._2_문자열;

public class Lv1_신규_아이디_추천_KAKAOBLIND {

	public String solution(String new_id) {
		new_id = new_id.toLowerCase(); // 1
		new_id = new_id.replaceAll("[^a-z0-9\\-._]", ""); // 2
		new_id = new_id.replaceAll("\\.+", "."); // 3
		new_id = new_id.replaceAll("^\\.+|\\.+$", ""); // 4
		new_id = new_id.isBlank() ? "a" : new_id; // 5
		new_id = new_id.length() >= 16 ? new_id.substring(0, 15) : new_id; // 6-1
		new_id = new_id.replaceAll("\\.+$", ""); // 6-2

		// 7
		while (new_id.length() <= 2) {
			new_id += new_id.charAt(new_id.length() - 1);
		}

		return new_id;
	}
}
