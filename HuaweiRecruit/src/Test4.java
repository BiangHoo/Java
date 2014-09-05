import java.util.Scanner;



public class Test4 {
	
	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		int count=s.nextInt();
		int i=0;
		while(i<count){
			int num =s.nextInt();
			reverse(num);
			i++;
		}
		
	}
	public static int reverse(int n){
		int result=0;
		
		int tmp=n;
		int len=0;
		while(tmp>0){
			len++;
			tmp /= 2;
		}
		int i=0;
		int digital[]=new int[len];
		while(n>0){
			if((n&1)==1){
				digital[i++]=1;
			}else{
				digital[i++]=0;
			}
			n = n>>1;
		}
		//System.out.println(Arrays.toString(digital));
		int val=0;
		for(int j=0;j<len;j++){
			val +=digital[j]*(1<<(len-1-j));
		}
		System.out.println(val);
		return 0;
	}
}
