package OJ;

import java.util.Scanner;

public class Test4441 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		int m = 0;
		boolean light[]=new boolean[n];
		for(int q=0;q<n;q++){
			light[q] = false;
		}
		while(i<=n){
			int k= n/i;
			int j=0;
			while(j<k){
				light[i+i*j-1] = !light[i+i*j-1];
				j++;
			}
			
			i++;
		}
		i=0;
		while(i<n){
			if(light[i]){
				m++;
			}
			i++;
		}
		System.out.println(m);
	}

}
