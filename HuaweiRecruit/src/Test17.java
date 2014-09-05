import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;


public class Test17 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		delete(str);
	}
	public static void delete(String str){
		Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
		 char strArray[] = str.toCharArray();
		 int strLen = strArray.length;
		 for(int i=0;i<strLen;i++){
			 if(ht.get(strArray[i])==null){
				 ht.put(strArray[i], 1);
			 }else{
				 ht.put(strArray[i], ht.get(strArray[i])+1);
			 }
		 }
		 Enumeration<Integer> flag = ht.elements();
		 int min = 10000;
		 while(flag.hasMoreElements()){
			 int key = flag.nextElement();
			 if(key<min){
				 min = key; 
			 }
		 }
		 String res ="";
		 for(int i=0;i<strLen;i++){
			 if(ht.get(strArray[i])!=min){
				 res = res.concat(String.valueOf(strArray[i]));
			 }
		 }
		 System.out.println(res);
	}

}
