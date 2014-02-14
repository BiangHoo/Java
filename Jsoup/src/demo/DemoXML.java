package demo;
import java.util.*;
import java.io.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements; 

/**
 * @author Bangwen Chen
 *
 * 2014年2月14日
 */
public class DemoXML {
	public static void main(String [] args){
		List<HashMap<String,String>> list=new DemoXML().getRssList("m");
		System.out.println(list.toString());
		File file = new File("E:\\config.xml");
		Document doc;
		try {
			doc = Jsoup.parse(file,"utf-8");
			System.out.println("select..");
			Elements m=doc.select("m");//find tag quickly by "select"
			for(Element outline:m){
				String name = outline.attr("name");
				System.out.println(name);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private List<HashMap<String,String>> getRssList(String id){
		List<HashMap<String,String>> list =  new ArrayList<HashMap<String,String>>();
		Document doc;
		File in=new File("E:\\config.xml");//打开文件
		try{
			doc =Jsoup.parse(in, "utf-8");
//			Element parent = doc.getElementsByTag(id);
			Elements outlines = doc.getElementsByTag("m");
			for(Element outline:outlines){
				if(outline.attr("id").equals("101")){
					String name = outline.attr("name");
					HashMap<String,String> map = new HashMap<String,String>();
					map.put("name",name );
					list.add(map);
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return list;
	}
}
