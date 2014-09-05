package OJ;

import java.util.Scanner;

public class Test4443 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M,S,T;
		Scanner s = new Scanner(System.in);
		M = s.nextInt();
		S = s.nextInt();
		T = s.nextInt();
		int len=0;
		int t=0;
		while(M>=10&&len<S&&t<T){
			len +=77;
			M -= 10;
			t++;
		}
		if(len>=S&&t<=T){//
			System.out.println("Yes"+" "+t);
		}else{
			if(t>=T){
				System.out.println("No"+" "+len);
			}else{
				//System.out.println("M:"+M);
				int rT=T-t;
				int rS=S-len;
				//剩余时间大于三秒
				while(rT>=3){
					rT--;
					M += 4;
					if(M >10){
						M -= 10;
						rS -= 77;
						if(rS<0){
							int time=T-rT;
							System.out.println("Yes"+" "+time);
						}
					}
				}
				
			}
		}
	}

}
