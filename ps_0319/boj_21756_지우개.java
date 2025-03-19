/*
이 문제는 모체의 ArrayList를 활용해 임시 ArrayList를 만들어
크기를 갱신해주며 값을 구할 수 있겠다
*/

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//import java.util.Arrays;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> box_row = new ArrayList<>();
		for (int i = 1; i < N+1; i++) {
			box_row.add(i);
		}
		
		
		while (box_row.size() > 1) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 1; i < box_row.size(); i+=2) {
				temp.add(box_row.get(i));
			}
			box_row = temp;
		}
		
		
		
		
		
		System.out.println(box_row.get(0));
//		System.out.println(box_row.size());
//		System.out.println(Arrays.toString(box));
		
		
		
	}
}