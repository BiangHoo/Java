import java.util.Scanner;


public class Test14 {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		count(str);
	}
	public static void count(String str){
		str= str.concat(String.valueOf(0));//���ַ�����һ��λ�ӣ��Ա㲻�ж����λ�ĸ���״��
		char array[] = str.toCharArray();
		int len = array.length;
		String out="";
		char letter = ' ';
		int count=0;
		if(len!=0){//�ж������Ƿ�Ϊ�գ���ֹ�ַ���Խ��
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
