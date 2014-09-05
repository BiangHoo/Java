
public class Test2 {
	public static void main(String args[]){
		Joseph(5,2,3);
	}
	public static void Joseph(int n,int s,int m){
		Node head=new Node(1,null);
		Node cur=head;
		Node start=null;
		for(int i=2;i<n+1;i++){
			Node tmp=new Node(i,null);
			cur.next=tmp;
			cur=tmp;
			if(i==s){
				start=cur;
				//System.out.println(start.num);
			}
		}
		cur.next=head;
		//System.out.println(cur.next.num);
		int k=1;
		while(n>1){
			Node pre=start;
			while(k<m){
				pre=start;
				start=start.next;
				k++;
			}
			//System.out.println(start.num);
			pre.next=start.next;
			start=start.next;
			n--;
			k=1;
		}
		System.out.println(start.num);
	}
}
class Node{
	int num;
	Node next;
	public Node(int num,Node next){
		this.next = next;
		this.num=num;
	}
}