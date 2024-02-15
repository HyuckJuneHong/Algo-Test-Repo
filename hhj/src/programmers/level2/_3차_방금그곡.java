package src.programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class _3차_방금그곡 {
	static Map<String, String> map = new HashMap<>();

	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		StringBuilder code;
		int time = 0;
		int max = 0;
		changeCodeSetting();
		m = change(m);

		for (String musicinfo : musicinfos) {
			String[] music = musicinfo.split(",");
			time = getTime(music[0], music[1]);
			music[3] = change(music[3]);
			code = new StringBuilder(music[3]);

			while (code.length() < time) {
				code.append(music[3]);
			}

			music[3] = code.substring(0, time);

			if (music[3].contains(m) && music[3].length() > max) {
				answer = music[2];
				max = music[3].length();
			}
		}

		return answer;
	}

	public String change(String str) {
		for (String key : map.keySet()) {
			str = str.replace(key, map.get(key));
		}

		return str;
	}

	public void changeCodeSetting() {
		map.put("C#", "c");
		map.put("D#", "d");
		map.put("F#", "f");
		map.put("G#", "g");
		map.put("A#", "a");
	}

	public int getTime(String str1, String str2) {
		String[] time1 = str1.split(":");
		String[] time2 = str2.split(":");

		int h1 = Integer.parseInt(time1[0]) * 60;
		int h2 = Integer.parseInt(time2[0]) * 60;

		int m1 = Integer.parseInt(time1[1]);
		int m2 = Integer.parseInt(time2[1]);

		return (h2 + m2) - (h1 + m1);
	}
}
