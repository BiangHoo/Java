import java.util.Hashtable;
import java.util.Scanner;


public class Test15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(func(str));
	}
	public static boolean func(String str){
		Hashtable<String,Integer> hs = new Hashtable<String,Integer>();
		int len = str.length();
		for(int i=0;i<=len;i++){
			for(int j=i+2;j<=len;j++){
				String sub = str.substring(i,j);
				//System.out.println(sub);
				if(hs.get(sub)==null){
					hs.put(sub,1);
				}else if(hs.get(sub)==1){
					return true;
				}
			}
		}
		return false;
	}

}
