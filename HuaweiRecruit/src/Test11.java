
public class Test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(11));
	}
	public static boolean isPalindrome(int num){
		boolean flag = true;
		if(num<0){//��Ϊ����������false
			return false;
		}
		if(num<10){//��Ϊ��λ�������Ϊ������
			return true;
		}
		int digit=1;
		int tmp = num;
		while(tmp>10){
			digit *= 10;
			tmp /= 10;
			
		}
		//System.out.println("digit"+digit);
		while(num>0){
			if(num/digit!=num%10){
				//System.out.println(num);
				flag = false;
				break;
			}
			num = (num%digit)/10;
			digit /= 100;
		}
		return flag;
	}

}
