import java.util.Scanner;


public class Test14 {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		count(str);
	}
	public static void count(String str){
		str= str.concat(String.valueOf(0));//将字符增加一个位子，以便不判断最后位的各种状况
		char array[] = str.toCharArray();
		int len = array.length;
		String out="";
		char letter = ' ';
		int count=0;
		if(len!=0){//判断数组是否为空，防止字符串越界
			letter =array[0];
		}
		for(int i=0;i<len;i++){
			if(array[i]==letter){
				count++;
			}else{
					out = out.concat(String.valueOf(array[i-1]));
					out = out.concat(String.valueOf(count));
					letter =array[i];
					count=1;
			}
		}
		System.out.println(out);
	}
}
