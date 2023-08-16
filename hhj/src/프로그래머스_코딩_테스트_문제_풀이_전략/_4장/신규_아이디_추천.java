package src.프로그래머스_코딩_테스트_문제_풀이_전략._4장;

public class 신규_아이디_추천 {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");
        new_id = new_id.replaceAll("\\.+", ".");
        new_id = new_id.replaceAll("^\\.+|\\.+$", "");
        new_id = new_id.isBlank() ? "a" : new_id;
        new_id = new_id.length() >= 16 ? new_id.substring(0, 15) : new_id;
        new_id = new_id.replaceAll("\\.+$", "");

        while (new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}
