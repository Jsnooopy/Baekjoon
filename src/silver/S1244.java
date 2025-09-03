package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1244 {
	static class Student{
		int sex, num;
		
		Student(int sex, int num){
			this.sex = sex;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] state = new int[N + 1];
		Student[] list = new Student[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			state[i] = Integer.parseInt(st.nextToken());
		}
		state[0] = 2;
		
		int stu = Integer.parseInt(br.readLine());
		for(int i = 0; i < stu; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[i] = new Student(a, b);
		}
		
		for(int i = 0; i < stu; i++) {
			Student s = list[i];
			int sex = s.sex;
			int num = s.num;
			
			if(sex == 1) {
				for(int j = 1; j <= N; j++) {
					if(j % num == 0) {
						if(state[j] == 0) state[j] = 1;
						else state[j] = 0;
					}
				}
			} else{
				if(state[num] == 0) state[num] = 1;
				else state[num] = 0;
				
				int front = num;
				int back = num;
				
				while(true) {
					front--;
					back++;
					
					if(front == 0 || back > N) break;
					
					if(state[front] != state[back]) break;
					else {
						if(state[front] == 0) state[front] = 1;
						else state[front] = 0;
						
						if(state[back] == 0) state[back] = 1;
						else state[back] = 0;
					}
				}
			}
		}
		
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			sb.append(state[i]).append(" ");
			cnt++;
			if(cnt == 20) {
				sb.append("\n");
				cnt = 0;
			}
		}
		
		System.out.println(sb);
	}

}
