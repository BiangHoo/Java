import java.util.Scanner;


public class StringComp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		String a = s.nextLine();
		String b = s.nextLine();
		System.out.println(compStr(a,b));
	}
	public static boolean compStr(String a,String b){
		a = a.toLowerCase();
		b = b.toLowerCase();
		int aLen = a.length();
		int bLen = b.length();
		if(aLen!=bLen){
			return false;
		}
		int i = 0;
		while(i<aLen){
			if(a.charAt(i)!=b.charAt(i)){
				return false;
			}
			i++;
		}
		return true;
	}
}
