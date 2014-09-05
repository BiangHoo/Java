import java.util.Scanner;


public class Primes {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		printPrime(num);
	}
	
	public static void printPrime(int num){
		for(int i=2;i<num;i++){
			if(isPrime(i)){
				System.out.print(i+" ");
			}
		}
		System.out.println("");
	}
	public static boolean isPrime(int n){//ÅÐ¶ÏÊÇ·ñÎªËØÊý
		//boolean flag =false;
		if(n<2){
			return false;
		}
		int count = 0;
		for(int i=1;i<=(int)Math.sqrt(n);i++){
			if(n%i==0){
				count++;
			}
		}
		if(count>1){
			return false;
		}
		return true;
	}

}
