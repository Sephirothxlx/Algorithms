package algorithm.stack;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		boolean res = true;
        if(s.length()==0)
            return true;
		if(s.length()%2==1) {
			return false;
		}
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				st.push(new Character(c));
			} else if (c == ')') {
				if (st.isEmpty()||st.pop().charValue() != '(') {
					res = false;
					break;
				}
			}else if (c == ']') {
				if (st.isEmpty()||st.pop().charValue() != '[') {
					res = false;
					break;
				}
			}else if (c == '}') {
				if (st.isEmpty()||st.pop().charValue() != '{') {
					res = false;
					break;
				}
			}
		}
		
		//stack has to be empty, such as the case "(("
        if(!st.isEmpty())
            return false;
		return res;
	}
	
	public static void main(String[]args) {
		ValidParentheses vp=new ValidParentheses();
		System.out.print(vp.isValid(""));
	}
}
