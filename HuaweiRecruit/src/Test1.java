import java.util.Arrays;


public class Test1 {
	public static int[] find(int [] array){
		int len=array.length;
		int [] result=new int[len];
		int j=0;
		for(int i=0;i<len;i++){
			if( (array[i]&(array[i]-1))==0 ){
				result[j++]=array[i];
			}
		}
		return result;
	}
	public static void main(String[] args){
		int array[]={2,3,4,16,20};
		int res[]=find(array);
		System.out.println(Arrays.toString(res));
	}
}
