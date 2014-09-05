package _2014;

import java.util.Scanner;

public class MoneyCombination {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int money = s.nextInt();
		comb(money);
	}
	public static void comb(int money){
		int count=0;
		count += money/100;
		money = money%100;
		count += money/50;
		money = money%50;
		count += money/20;
		money = money%20;
		count += money/10;
		money = money%10;
		count += money/5;
		money = money%5;
		count += money/1;
		System.out.println(count);
	}

}
