package OJ;

import java.util.Scanner;

public class Test4433 {
	public static void main(String args[]){
		Scanner s =new Scanner(System.in);
		
		String str=s.next();
		System.out.println(convert(str));
	}
	public static int convert(String str){
		int digit=0;
		if(str.charAt(0)=='0'){
			if(str.charAt(1)=='v'||str.charAt(1)=='V'){
				digit = 9;
			}else if(str.charAt(1)=='w'||str.charAt(1)=='W'){
				digit = 11;
			}else{
				return -1;
			}
		}else{
			return -1;
		}
		
		String sub=str.substring(2);
		if(sub.length() == 0){
			return 0;
		}
		while(sub.length()!=0&&sub.charAt(0)=='0'){
			sub = sub.substring(1);
		}
		int subLen=sub.length();
		if(subLen>8){
			return -1;
		}
		if(subLen == 0){
			return 0;
		}
		int result=0;
		if(digit==9){
			for(int i=0;i<subLen;i++){
				int val=0;
				if(sub.charAt(i)>='0'&&sub.charAt(i)<'9'){
					val = Integer.parseInt(String.valueOf(sub.charAt(i)));
					result += val * Math.pow(digit, subLen-i-1);
				}else{
					return -1;
				}
			}
		}else if(digit==11){
			for(int i=0;i<subLen;i++){
				int val=0;
				if((sub.charAt(i)>='0'&&sub.charAt(i)<='9')||sub.charAt(i)=='A'||sub.charAt(i)=='a'){
					if(sub.charAt(i)=='A'||sub.charAt(i)=='a'){
						val=10;
					}else{
						val = Integer.parseInt(String.valueOf(sub.charAt(i)));
					}
					result += val * Math.pow(digit, subLen-i-1);
				}else{
					return -1;
				}
			}
		}else{
			return -1;
		}
		return result;
	}
}
