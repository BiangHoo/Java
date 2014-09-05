import java.math.BigDecimal;
import java.util.Scanner;


public class BigDecimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String s1 = s.nextLine();
		String s2 = s.nextLine();
		BigDecimal b1 = new BigDecimal(s1);
		BigDecimal b2 = new BigDecimal(s2);
		BigDecimal result = b1.multiply(b2);
		System.out.println(result);
	}

}
