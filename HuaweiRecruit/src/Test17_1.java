import java.util.Scanner;


public class Test17_1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		delete(str);
	}
	public static void delete(String str){
		int hash[] = new int[256];
		for(int i=0;i<256;i++){
			hash[i]=0;
		}
		char[] strArray =str.toCharArray();
		int len =strArray.length;
		for(int i=0;i<len;i++){
			hash[strArray[i]]++;
		}
		int min=0x7fffffff;
		for(int i=0;i<256;i++){
			if(hash[i]<min&&hash[i]!=0){
				min = hash[i];
			}
		}
		String res = "";
		for(int i=0;i<len;i++){
			if(hash[strArray[i]]!=min){
				res =res.concat(String.valueOf(strArray[i]));
			}
		}
		System.out.println(res);
	}

}
