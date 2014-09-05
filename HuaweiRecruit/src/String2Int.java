import java.util.Scanner;


public class String2Int {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(convert(str));

	}
	public static int convert(String str){
		int result=0;
		char[] strArray = str.toCharArray();
		int strLen = strArray.length;
		for(int i=0;i<strLen;i++){
			int val= Integer.parseInt(String.valueOf(strArray[i]));
			result += val*(Math.pow(10,strLen-i-1 ));
		}
		return result;
	}

}
