import java.util.Arrays;
import java.util.Scanner;


public class _1Letter2UpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str =s.nextLine();
		toUpperCase(str);
	}
	public static void toUpperCase(String str){
		String [] strArray = str.split(" ");
		//System.out.println(Arrays.toString(strArray));
		for(int i=0;i<strArray.length;i++){
			String letter =strArray[i].substring(0, 1);
			letter = letter.toUpperCase();
			strArray[i] = letter +strArray[i].substring(1);
		}
		//System.out.println(Arrays.toString(strArray));
		String res="";
		for(int i=0;i<strArray.length;i++){
			if(res==""){
				res =res.concat(strArray[i]);
			}else{
				res =res.concat(" " + strArray[i]);
			}
		}
		System.out.println(res);
	}

}
