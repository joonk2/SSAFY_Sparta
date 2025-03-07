/*
[접근 방식]
XOR 연산을 통해 푼다

[제약사항]
- 이 문제는 split(" ") 불가능 --> 즉 String[] 입력을 못 받는다는 말이다
- Scanner 만 가능

[입력]
3
3
1 1 2
1
1
5
3 1 2 1 2

[출력]
#1 2
#2 1
#3 3
*/



package swea;



import java.util.Scanner;
//import java.util.Arrays;


public class swea_22149_출입감시 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 1; tc < T+1; tc++) {
			int people = sc.nextInt();
			sc.nextLine();
			
			String[] id_arr = sc.nextLine().split(" ");
			int[] id_lst = new int[id_arr.length];
			
			int xor_cnt = 0;
			for (int i = 0; i < id_arr.length; i++) {
				id_lst[i] = Integer.parseInt(id_arr[i]);
				int temp = id_lst[i];
				xor_cnt ^= temp;
			}
			
			
			System.out.println("#" + tc + " " + xor_cnt);
			
				
			
//			System.out.println(Arrays.toString(id_lst));
			
		}
		
		
	}
}