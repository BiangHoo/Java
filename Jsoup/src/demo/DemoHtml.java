package demo;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;
public class DemoHtml {
	public static void main (String [] args){
		try{
			String sum_content = "";
			Document doc = Jsoup.connect("http://caipiao.taobao.com/lottery/awardresult/lottery_ssq.htm").get();
			Element content = doc.getElementById("i-bd");
			Elements tags = content.getElementsByTag("span");
			for(Element tag:tags){
				String attr = tag.attr("class");
				if(attr.equals("cb")){
					sum_content += tag.text()+" ";
				}
			}
			System.out.println("¿ª½±½á¹û£º"+sum_content);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
