import java.util.Arrays;
import java.util.Scanner;


public class Test13 {
	public static void main(String args[] ){
		Scanner s = new Scanner(System.in);
		int array[][]={{1,2,3,9,20},{4,1,7,6,17},{0,3,4,8,32},{4,9,2,1,14}};
		int out[]=new int[5];
		for(int i=0;i<5;i++){
			int key = array[0][i];
			for(int j=0;j<4;j++){
				if(array[j][i]<key){
					key = array[j][i];
				}
			}
			out[i]=key;
		}
		System.out.println(Arrays.toString(out));
	}
	
	//public static void 
}
