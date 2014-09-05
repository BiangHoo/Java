import java.util.Arrays;
import java.util.Stack;


public class Test5_1 {

	public static void main(String[] args) {
		String test = "Iknow(((d)fd()onf))";
		System.out.println(isMatch(test));
	}
	public static boolean isMatch(String str){
		
		Stack<Character> stack=new Stack<Character>();
		char array[] = str.toCharArray();
		int arrLen = array.length;
		char match[] = new char[arrLen];
		int n=0;
		for(int i=0;i<arrLen;i++){
			if(array[i]=='('||array[i]==')'){
				match[n++]=array[i];
			}
		}
		System.out.println(Arrays.toString(match));
		for(int i=0;i<n;i++){
			if(match[i]=='('){
				stack.push('(');
			}else{
				if(stack.isEmpty()){
					return false;
				}
				stack.pop();
			}
		}
		if(stack.isEmpty()){
			return true;
		}
		return false;
	}

}
