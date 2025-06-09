package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj_25206_너의평점은 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 20;
		double score_sum = 0;
		double credit_hour_sum = 0;
		for (int i = 0; i < N; i++) {
			String[] class_creditHour_grade = br.readLine().split(" ");
//			String class_name = class_creditHour_grade[0];
			double credit_hour = Double.parseDouble(class_creditHour_grade[1]);
			String grade = class_creditHour_grade[2];
			
			// 한 과목의 등급이 P면 계산에서 제외
			if (grade.equals("P")) {
				continue;
			}
			
			
			double g = grade_converter(grade);
//			System.out.println(g);
			credit_hour_sum += credit_hour;
			score_sum += (credit_hour*g);
			
		}
		
		double res = (score_sum / credit_hour_sum);
		System.out.printf("%.6f\n", res);
		
	}
	
	// 등급 변환기
	public static double grade_converter(String grade) {
		double res = 0;
		if (grade.equals("A+")) {
			res = 4.5;
		}
		else if (grade.equals("A0")) {
			res = 4.0;
		}
		else if (grade.equals("B+")) {
			res = 3.5;
		}
		else if (grade.equals("B0")) {
			res = 3.0;
		}
		else if (grade.equals("C+")) {
			res = 2.5;
		}
		else if (grade.equals("C0")) {
			res = 2.0;
		}
		else if (grade.equals("D+")) {
			res = 1.5;
		}
		else if (grade.equals("D0")) {
			res = 1.0;
		}
		else if (grade.equals("F")) {
			res = 0.0;
		}
		return res;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}