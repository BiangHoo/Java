package ProducerConsumer;

public class Producer implements Runnable {
	private String producerName;
	private StoreHouse storeHouse;
	public Producer(String producerName,StoreHouse storeHouse){
		this.producerName = producerName;
		this.storeHouse = storeHouse;
	}
	public void setProducerName(String producerName){
		this.producerName = producerName;
	}
	public String getProducerName(){
		return producerName;
	}
	public void run(){
		execProduct();
	}
	private void execProduct(){
		int i=0;
		while(true){
			i++;
			Product pro = new Product(i);
			storeHouse.push(pro);
			System.out.println(getProducerName()+"produces "+ pro);
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				return;
			}
		}
	}
}
//the sourceCode is from http://www.cnblogs.com/dennisit/archive/2013/02/25/2931573.html