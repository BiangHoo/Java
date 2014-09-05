package OJ;

import java.util.Scanner;

public class Test445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int No=0;
		int count=0;
		int []queue = new int[100001];
		int []vipQue = new int[100001];
		boolean []isVip = new boolean[100001];
		for(int i=0;i<100001;i++){
			isVip[i] = false;
		}
		int vipNo=0;
		int vipCount=0;
		while(str!=null){
			if(str.equals("get")){
				count++;
				No++;
				queue[No]=No;
				System.out.println(No);
			}else if(str.equals("get vip")){
				count++;
				No++;
				vipCount++;
				queue[No]=No;
				isVip[No]=true;
				vipQue[vipNo++]=No;
				System.out.println("vip "+No);
			}else if(str.equals("count")){
				System.out.println(count);
			}else if(str.startsWith("countN ")){
				int countNo = Integer.parseInt(str.substring(7));
				int sumN=0;
				for(int i=1;i<countNo;i++){
					if(queue[i]!=0){
						sumN++;
					}
				}
				System.out.println(sumN);
			}else if(str.startsWith("delete")){
				str = str.substring(7);
				int delNo = Integer.parseInt(str);
				if(queue[delNo] != 0){
					if(isVip[delNo]){
						vipCount--;
						count--;
						System.out.println("vip " + delNo);
					}else{
						count--;
						System.out.println(delNo);
					}
					queue[delNo] = 0;
				}else{
					System.out.println("error");
				}
				if(delNo==No){
					No--;
				}
			}else if(str.equals("quit")){
				break;
			}else if(str.equals("reset")){
				count = 0;
				No = 0;
				for(int i=0;i<queue.length;i++){
					queue[i] = 0;
				}
				for(int i=0;i<vipQue.length;i++){
					vipQue[i] = 0;
				}
				for(int i=0;i<isVip.length;i++){
					isVip[i] = false;
				}
			}else if(str.equals("call")){
				if(vipCount!=0){
					for(int i=0;i<=vipCount;i++){
						if(vipQue[i] != 0){
							System.out.println("vip "+vipQue[i]);
							queue[vipQue[i]]=0;
							vipQue[i] = 0;
							count--;
							vipCount--;
							break;
						}
					}
				}else{
					int i=0;
					if(count==0){
						System.out.println("error");
					}else{
						for(i=1;i<=No;i++){
							if(queue[i] != 0){
								System.out.println(queue[i]);
								queue[i] = 0;
								count--;
								break;
							}
						}
					}
				}
			}
			str =s.nextLine();
		}
	}
}
