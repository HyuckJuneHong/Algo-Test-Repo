package src.프로그래머스.level2;

public class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int size = name.length();

        int index = 0;          // 현재 탐색 중인 문자 위치
        int move = size - 1;    // 좌우 이동 횟수

        for (int i = 0; i < size; i++) {
            // 상하 위치를 구하며 더해간다. (A부터 시작할 지 Z부터 시작할 지를 정함
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            index = i + 1;

            // 연속되는 A의 갯수를 확인하는 부분
            // A의 연속되는 갯수를 기반으로 A기준 뒷부분의 길이와, A기준 앞부분의 길이를 판단.
            // 이 길이를 기반으로 앞쪽, 뒷쪽 어디가 더 빠른지를 계산.
            while (index < size && name.charAt(index) == 'A') {
                index++;
            }

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move = Math.min(move, i * 2 + size - index);    // 현재 위치 = A의 가장 앞 (현재 위치에서 처음으로 갔다가 되돌아 온 수 + A 가장 끝 부분부터 끝까지 가는 수)
            // 2022년 이전 테스트 케이스만 확인하면 여기까지해도 정답처리가 되기 때문에, 이전 정답들에는 여기까지만 정리되어 있지만,
            // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
            move = Math.min(move, (size - index) * 2 + i);  // A의 가장 끝 부분에서 끝까지 갔다가 되돌아 오는 수 + A의 가장 앞
        }

        // 상하 변경 횟수 + 좌우 이동 횟수
        return answer + move;
    }
}
