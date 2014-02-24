package ProducerConsumer;

public class StoreHouse {
	private int base = 0;
	private int top = 0;
	private Product[] products = new Product[10];
	public synchronized void push(Product product){
		if(top==products.length){
			notify();
			try{
				System.out.println("The StoreHouse is full,wait for consuming..");
				wait();
			}catch(InterruptedException e){
				System.out.println("Stop push product");
			}
		}
		products[top]=product;
		top++;
	}
	public synchronized Product pop(){
		Product product =null;
		while(top==base){
			notify();
			try{
				System.out.println("the storeHouse is empty,wait for producing");
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		top--;
		product = products[top];
		products[top] = null;
		return product;
	}
}
//the sourceCode is from http://www.cnblogs.com/dennisit/archive/2013/02/25/2931573.html