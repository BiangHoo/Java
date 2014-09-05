import java.util.Scanner;


public class Test3 {
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		while(true){
			int n=s.nextInt();
			countBits(n);
		}
	}
	public static int countBits(int n){
		
		int k = 0;
		int len = 0;
		int tmp = n;
		
		while(tmp>0){
			len++;
			tmp /= 2;
		}
		while(n>0){
			k++;
			n = n&(n-1);
		}
		System.out.println(len-k);
		return len-k;
	}
}
