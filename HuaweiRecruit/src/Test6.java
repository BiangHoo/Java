
public class Test6 {
//查找子字符串个数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "xfdshooxixihooadadshoosfdsfhhoohoooo";
		String sub = "hoo";
		System.out.println(query(text,sub));
	}
	public static int query(String str,String sub){
		int num = 0;
		int strLen = str.length();
		int subLen = sub.length();
		int i=0;
		while(i<strLen){
			if(str.charAt(i) == sub.charAt(0)){
				boolean flag = false;
				for(int j=0;j<subLen;j++){
						if(i+j == strLen || str.charAt(i+j) != sub.charAt(j)){
							i = i+j;
							break;
						}
						if(j == subLen-1){
							flag = true;
						}
				}
				if(flag){
					num++;
					if(i+subLen<strLen){
						i = i+subLen;
					}	
				}
			}else{
				i++;
			}
		}
		return num;
	}
	
}
