/*
1. 정렬을 한다
2. 가벼운 사람과 제일 무거운 사람부터 확인한다
3. 제한무게 초과시 맨 끝사람부터 보트를 태워 보낸다
4. 전부 다 태우면 종료
*/

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length-1;
        
        while (start <= end) {
            int temp_sum = (people[start] + people[end]);
            if (temp_sum > limit) {
                end--;
                answer++;
            }
            else if (temp_sum <= limit) {
                start++;
                end--;
                answer++;
            }
        }
        
        
        return answer;
    }
}