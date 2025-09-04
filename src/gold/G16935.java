package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G16935 {
	
	static int N, M, R;
	static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			int what = Integer.parseInt(st.nextToken());
			
			switch(what) {
			case 1:
				one();
				break;
				
			case 2:
				two();
				break;
				
			case 3:
				three();
				break;
				
			case 4:
				four();
				break;
				
			case 5:
				five();
				break;
				
			case 6:
				six();
				break;
			}
		}
		
		int n = arr.length;
		int m = arr[0].length;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	} // main
	
	static void one() {
		int n = arr.length;
		int m = arr[0].length;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n / 2; j++) {
				int temp = arr[j][i];
				arr[j][i] = arr[n - 1 - j][i];
				arr[n - 1 - j][i] = temp;
			}
		}
	}
	
	static void two() {
		int n = arr.length;
		int m = arr[0].length;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][m - 1 - j];
				arr[i][m - 1 - j] = temp;
			}
		}
	}
	
	static void three() {
		int n = arr.length;
		int m = arr[0].length;
		
		int[][] temp = new int[m][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				temp[j][n - 1 - i] = arr[i][j];
			}
		}
		
		arr = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}
	
	static void four() {
		int n = arr.length;
		int m = arr[0].length;
		
		int[][] temp = new int[m][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				temp[m - 1 - j][i] = arr[i][j];
			}
		}
		
		arr = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}
	
	static void five() {
		int n = arr.length;
		int m = arr[0].length;
		
		int[][] temp = new int[n][m];
		int halfN = n / 2;
		int halfM = m / 2;
		
		for(int i = 0; i < halfN; i++) {
			for(int j = 0; j < halfM; j++) {
				temp[i][j + halfM] = arr[i][j];
			}
		} // 1사분면
		
		for(int i = 0; i < halfN; i++) {
			for(int j = halfM; j < m; j++) {
				temp[i + halfN][j] = arr[i][j];
			}
		} // 2사분면
		
		for(int i = halfN; i < n; i++) {
			for(int j = halfM; j < m; j++) {
				temp[i][j - halfM] = arr[i][j];
			}
		} // 3사분면
		
		for(int i = halfN; i < n; i++) {
			for(int j = 0; j < halfM; j++) {
				temp[i - halfN][j] = arr[i][j];
			}
		} // 4사분면
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}
	
	static void six() {
		int n = arr.length;
		int m = arr[0].length;
		
		int[][] temp = new int[n][m];
		int halfN = n / 2;
		int halfM = m / 2;
		
		for(int i = 0; i < halfN; i++) {
			for(int j = 0; j < halfM; j++) {
				temp[i + halfN][j] = arr[i][j];
			}
		} // 1사분면
		
		for(int i = 0; i < halfN; i++) {
			for(int j = halfM; j < m; j++) {
				temp[i][j - halfM] = arr[i][j];
			}
		} // 2사분면
		
		for(int i = halfN; i < n; i++) {
			for(int j = halfM; j < m; j++) {
				temp[i - halfN][j] = arr[i][j];
			}
		} // 3사분면
		
		for(int i = halfN; i < n; i++) {
			for(int j = 0; j < halfM; j++) {
				temp[i][j + halfM] = arr[i][j];
			}
		} // 4사분면
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}

}
