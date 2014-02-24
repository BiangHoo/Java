package ProducerConsumer;

public class Consumer implements Runnable{
	private String consumerName;
	private StoreHouse storeHouse;
	public Consumer(String consumerName,StoreHouse storeHouse){
		this.consumerName = consumerName;
		this.storeHouse = storeHouse;
	}
	public void setConsumerName(String consumerName){
		this.consumerName = consumerName;
	}
	public String getConsumerName(){
		return consumerName;
	}
	public void run(){
		execConsume();
	}
	private void execConsume(){
		while(true){
			System.out.println(getConsumerName()+"produces "+ storeHouse.pop());
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
				return;
			}
		}
	}
}
//the sourceCode is from http://www.cnblogs.com/dennisit/archive/2013/02/25/2931573.html