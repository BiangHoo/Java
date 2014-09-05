import java.util.Scanner;


public class Test16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str =s.nextLine();
		transfer2Num(str);
	}
	public static void transfer2Num(String str){
		String num="";
		while(str.length()!=0){
			if(str.startsWith("y")){
				num = num.concat("1");
				str =str.substring(2);
			}else if(str.startsWith("e")){
				num = num.concat("2");
				str =str.substring(2);
			}else if(str.startsWith("w")){
				num = num.concat("5");
				str =str.substring(2);
			}else if(str.startsWith("l")){
				num = num.concat("6");
				str =str.substring(3);
			}else if(str.startsWith("q")){
				num = num.concat("7");
				str =str.substring(2);
			}else if(str.startsWith("b")){
				num = num.concat("8");
				str =str.substring(2);
			}else if(str.startsWith("j")){
				num = num.concat("9");
				str =str.substring(3);
			}else if(str.startsWith("s")){
				if((str.substring(1)).startsWith("a")){
					num = num.concat("3");
					str=str.substring(3);
				}else{
					num = num.concat("4");
					str =str.substring(2);
				}
			}
			//System.out.println(str.length());
		}
		int n = Integer.parseInt(num);
		System.out.println(n);
	}

}
