package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G1918 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		char[] arr = s.toCharArray();
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : arr) {
			if(Character.isUpperCase(c)) {
				sb.append(c);
			} else if(c == '+') {
				if(!stack.isEmpty()) {
					if(stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '-' || stack.peek() == '+') {
						while(!stack.isEmpty()) {
							if(stack.peek() == '(') break;
							sb.append(stack.pop());
						}
					}
				}
				stack.add(c);
			} else if(c == '-') {
				if(!stack.isEmpty()) {
					if(stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-') {
						while(!stack.isEmpty()) {
							if(stack.peek() == '(') break;
							sb.append(stack.pop());
						}
					}
				}
				stack.add(c);
			} else if(c == '*') {
				if(!stack.isEmpty()) {
					if(stack.peek() == '/' || stack.peek() == '*') {
						sb.append(stack.pop());
					}
				}				
				stack.add(c);
			} else if(c == '/') {
				if(!stack.isEmpty()) {
					if(stack.peek() == '*' || stack.peek() == '/') {
						sb.append(stack.pop());
					}
				}
				stack.add(c);
			} else if(c == '(') {
				stack.add(c);
			} else if(c == ')') {
				while(!stack.isEmpty()) {
					if(stack.peek() == '(') {
						stack.pop(); 
						break;
					}
					sb.append(stack.pop());
				}
			}

		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
		
	}

}
