package ProducerConsumer;

public class TestPC {
	public static void main(String args[]){
		StoreHouse storeHouse = new StoreHouse();
		Producer producer = new Producer("������",storeHouse);
		Consumer consumer = new Consumer("������",storeHouse);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		t1.start();
		t2.start();
	}

}
//the sourceCode is from http://www.cnblogs.com/dennisit/archive/2013/02/25/2931573.html