


public class Test5 {
	//括号匹配
	public static void main(String[] args){
		String test = "Iknow((d)fd()onf))";
		System.out.println(isMatch(test));
	}
	public static boolean isMatch(String str){
		boolean flag = false;
		char[] arr = str.toCharArray();
		int len = str.length();
		char[] match = new char[len];
		int num = 0;//记录括号的个数
		int left = 0;//左括号
		int right = 0;//右括号
		for(int i=0;i<len;i++){
			if(arr[i]=='('||arr[i]==')'){
				match[num++]=arr[i];
				if(arr[i]=='('){
					left++;
					//System.out.println("left"+left);
				}else{
					right++;
					//System.out.println("right"+right);
				}
			}
			if(right>left){
				return false;
			}
		}
		if(left==right){//若括号个数为单数或左右括号数目不相等则返回false
			flag =true;
		}
		
		return flag;
	}
}
