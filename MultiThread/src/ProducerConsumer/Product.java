package ProducerConsumer;

public class Product {
	private int productId = 0;
	public Product(int productId){
		this.productId = productId;
	}
	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}
	public String toString(){
		return ""+productId;
	}
}
//the sourceCode is from http://www.cnblogs.com/dennisit/archive/2013/02/25/2931573.html
