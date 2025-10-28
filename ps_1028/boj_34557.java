package boj;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	static int N, M;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static boolean[] prev_pressed;
	static int[][] matrix;
	static String[] assigned_event;
	static int pos_r, pos_c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		matrix = new int[N][N];
		pos_r = 0;
		pos_c = 0;
		for (int r = 0; r < N; r++) {
			String[] cols = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				matrix[r][c] = Integer.parseInt(cols[c]);
				if (matrix[r][c] == 2) {
					pos_r = r;
					pos_c = c;
				}
			}
		}
		
		assigned_event = new String[4];
		for (int i = 0; i < 4; i++) {
			String event = br.readLine();
			assigned_event[i] = event;
		}
		
		String frames = br.readLine();
		prev_pressed = new boolean[4];
		simulate(frames);
		++pos_r;
		++pos_c;
		System.out.println(pos_r + " " + pos_c);
	}
	
	
	
	static void simulate(String frames) {
		for (int f = 0; f < M; f++) {
			char key = frames.charAt(f);
			int now_idx = get_idx(key);
			boolean[] now_pressed = new boolean[4];
			now_pressed[now_idx] = true;
			for (int button = 0; button < 4; button++) {
				String ev = get_event(prev_pressed[button], now_pressed[button]);
				if (ev != null && ev.equals(assigned_event[button])) {
					move(button);
				}
			}
			
			// 버튼 클릭 갱신
			prev_pressed = now_pressed;
		}
	}
	
	
	
	static int get_idx(char key) {
		if (key == 'W') return 0;
		if (key == 'A') return 1;
		if (key == 'S') return 2;
		return 3;
	}
	
	
	static String get_event(boolean prev, boolean now) {
		if (!prev && now) return "Down";
		if (prev && now) return "Stay";
		if (prev && !now) return "Up";
		return null;
	}
	
	
	static void move(int d) {
		int nr = pos_r + dr[d];
		int nc = pos_c + dc[d];
		
		// 맵밖이면 끝
		if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1) return;
		
		// 장애물 조우시 끝
		if (matrix[nr][nc] == 1) return;
		
		pos_r = nr;
		pos_c = nc;
	}
	
}