import java.util.Arrays;

//
public class Test10 {
	public static void main(String args[]){
		String str="ABCDEFZghiz";
		System.out.println(replace(str));
	}
	public static String replace(String str){
		int len=str.length();
		int i=0;
		char arr[] =str.toCharArray();
		while(i<len){
			if(arr[i]!='Z'&&arr[i]!='z'){
				char tmp = arr[i];
				tmp = (char)(tmp+1);
				arr[i]=tmp;
			}else{
				if(arr[i]=='Z'){
					arr[i]='A';
				}
				if(arr[i]=='z'){
					arr[i]='a';
				}
			}
			i++;
		}
		String res = String.valueOf(arr);
		
		return res;
	}
}
