


public class Test5 {
	//����ƥ��
	public static void main(String[] args){
		String test = "Iknow((d)fd()onf))";
		System.out.println(isMatch(test));
	}
	public static boolean isMatch(String str){
		boolean flag = false;
		char[] arr = str.toCharArray();
		int len = str.length();
		char[] match = new char[len];
		int num = 0;//��¼���ŵĸ���
		int left = 0;//������
		int right = 0;//������
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
		if(left==right){//�����Ÿ���Ϊ����������������Ŀ������򷵻�false
			flag =true;
		}
		
		return flag;
	}
}
