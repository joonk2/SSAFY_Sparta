/*
-------------------------특별한 다이얼 자물쇠--------------------------

일반적인 다이얼 자물쇠는 위로 돌리면 숫자가 증가, 아래로 돌리면 숫자가 감소합니다.
하지만 이번 문제의 자물쇠는 조금 특별합니다.

특징은 다음과 같습니다:
특정 다이얼에서 up(+) 또는 down(-) 회전을 하면, 그 다이얼부터 마지막 다이얼까지 모두 함께 회전한다.
예를 들어, 다이얼이 12자리라고 할 때:
3번째 다이얼에서 1칸 up → 3번째부터 12번째까지 모든 다이얼 숫자가 1 증가
7번째 다이얼에서 3칸 down → 7번째부터 12번째까지 모든 다이얼 숫자가 3 감소

문제 정의
현재 다이얼 상태 dials가 주어졌을 때, 이를 목표 상태 target으로 만들고자 한다.
이때 필요한 최소 회전 횟수를 구하는 프로그램을 작성하라.


조건
1 <= dials.length <= 100000

testcase1
dials = {0,0,0,0,0,0}
target = {1,2,3,4,5,6}
result = 6

testcase2
dials {9,8,7}
target = {0,7,7}
result = 4

testcase3
dials = {0,6,1,4,5}
target = {8,3,1,9,6}
result = 15
*/



import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dials = br.readLine().split(" ");
		String[] target = br.readLine().split(" ");
		N = dials.length;
		int[] d = new int[N];
		int[] t = new int[N];
		
		for (int i = 0; i < N; i++) {
			d[i] = Integer.parseInt(dials[i]);
			t[i] = Integer.parseInt(target[i]);
		}
		
		min_rotate(d, t);
	}
	
	
	
	
	static void min_rotate(int[] d, int[] t) {
		int cnt = 0;
		int c_sum = 0;
		
		for (int i = 0; i < N; i++) {
			int down = ((((c_sum + d[i] + 10) % 10) + 10) - t[i]) % 10;
			int up = ((t[i] + 10) - ((c_sum + d[i] + 10) % 10)) % 10;
			
			if (down <= up) {
				c_sum -= down;
				cnt += down;
			}
			else if (up < down) {
				c_sum += up;
				cnt += up;
			}
		} 
		System.out.println(cnt);
		
	}
	
	
}