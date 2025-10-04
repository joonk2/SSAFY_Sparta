import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dr = {0,-1,0,1};
	static int[] dc = {-1,0,1,0};
	
	static int[] dr_diag = {1, 1};
	static int[] dc_diag = {-1, 1};
	
	static int N;
	static int x, y;
	static int cnt;
	static int wraist_pos_r = 0, wraist_pos_c = 0;
	static char[][] arr;
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int r = 0; r < N; r++) {
			String cols = br.readLine();
			for (int c = 0; c < N; c++) {
				arr[r][c] = cols.charAt(c);
			}
		}
		
		heart(arr);
		my_body_info(x, y, arr);
	}
	
	
	
	static void heart(char[][] arr) {
		for (int r = 0; r < N; r++) {
			if (check(cnt) == true) break;
			for (int c = 0; c < N; c++) {
				cnt = 0;
				if (arr[r][c] == '*') {
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							if (arr[nr][nc] == '*') cnt++;
						}
						else break;
					}
				}
				if (check(cnt) == true) {
					x = r;
					y = c;
				}
			}
		}
		System.out.println((x+1) + " " + (y+1));
	}
	
	
	
	
	static boolean check(int cnt) {
		if (cnt == 4) {
			return true;
		}
		return false;
	}
	
	
	
	static void my_body_info(int x, int y, char[][] arr) {
		int cr;
		int cc;
		
		// left_arm
		cr = x;
		cc = y;
		int left_arm_cnt = 0;
		while (true) {
			int nr = cr + dr[0];
			int nc = cc + dc[0];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == '*') {
				cr = nr;
				cc = nc;
				left_arm_cnt++;
			}
			else break;
		}
		
		
		// right_arm
		cr = x;
		cc = y;
		int right_arm_cnt = 0;
		while (true) {
			int nr = cr + dr[2];
			int nc = cc + dc[2];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == '*') {
				cr = nr;
				cc = nc;
				right_arm_cnt++;
			}
			else break;
		}
		
		
		// wraist
		cr = x;
		cc = y;
		int cnt_wraist = 0;
		while (true) {
			int nr = cr + dr[3];
			int nc = cc + dc[3];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == '*') {
				cr = nr;
				cc = nc;
				cnt_wraist++;
			}
			else {
				wraist_pos_r = cr;
				wraist_pos_c = cc;
				break;
			};
		};
		
		
		
		// left_leg && right_leg
		int diag_r;
		int diag_c;
		
		// left_leg
		int cnt_left_leg = 0;
		diag_r = wraist_pos_r;
		diag_c = wraist_pos_c;
		diag_r = diag_r + dr_diag[0];
		diag_c = diag_c + dc_diag[0];
		cnt_left_leg++;
		while (true) {
			int nr = diag_r + dr[3];
			int nc = diag_c + dc[3];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == '*') {
				diag_r = nr;
				diag_c = nc;
				cnt_left_leg++;
			}
			else break;
		}
		
		
		// right_leg
		int cnt_right_leg = 0;
		diag_r = wraist_pos_r;
		diag_c = wraist_pos_c;
		diag_r = diag_r + dr_diag[1];
		diag_c = diag_c + dc_diag[1];
		cnt_right_leg++;
		while (true) {
			int nr = diag_r + dr[3];
			int nc = diag_c + dc[3];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == '*') {
				diag_r = nr;
				diag_c = nc;
				cnt_right_leg++;
			}
			else break;
		}
		
		
		System.out.print(left_arm_cnt + " ");
		System.out.print(right_arm_cnt + " ");
		System.out.print(cnt_wraist + " ");
		System.out.print(cnt_left_leg + " ");
		System.out.print(cnt_right_leg);
	}
	
	
	
	
	
	
	
	static boolean stop(int cr, int cc, int nr, int nc) {
		if (arr[cr][cc] != arr[nr][nc]) {
			return false;
		}
		return true;
	}
	
}