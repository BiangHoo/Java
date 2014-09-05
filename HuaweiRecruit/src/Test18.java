import java.util.Scanner;


public class Test18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		String b = s.nextLine();
		add(a,b);
	}
	public static void add(String a,String b){
		int aLen = a.length();
		int bLen = b.length();
		int maxLen = aLen>bLen?aLen:bLen;
		if(a.length()!=maxLen){
			while(a.length() != maxLen){
				a = "0" + a;
			}
		}else{
			while(b.length() != maxLen){
				b = "0" + b;
			}
		}
		//System.out.println(a+" "+b);
		char aArray[] = a.toCharArray();
		char bArray[] = b.toCharArray();
		int aN,bN,val;
		int carry=0;
		String result="";
		for(int i=maxLen-1;i>=0;i--){
			 aN = Integer.parseInt(String.valueOf(aArray[i]));
			 bN = Integer.parseInt(String.valueOf(bArray[i]));
			 val =aN+bN+carry;
			 carry = val/10;
			 result = String.valueOf(val%10) +result;
			 //System.out.println(result);
		}
		if(carry!=0){
			result = String.valueOf(carry)+result;
		}
		System.out.println(result);
	}

}
