package mb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import net.sourceforge.htmlunit.corejs.javascript.NativeArray;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTableDataCell;

public class JunkPrice {
	
	public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Random generator = new Random();
	
	public static final String link = "?a=auction&do=closed&t=69&itemClass=99&itemType=0&prefix=99&suffix=99&legend=99&withoff=1&onlyMine=0&p="; 

	public class JunkPriceData{
		public int price;
		public int qty;
		public Date date;
	}
	
	public ArrayList<JunkPriceData> getAllJunkPrices(int startFrom) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParseException, InterruptedException{
		ArrayList<JunkPriceData> res = new ArrayList<JunkPrice.JunkPriceData>();
		ArrayList<JunkPriceData> tmp;
		int i = startFrom;
		do{
			tmp = getJunkPircesByPage(i);
			if(tmp != null && !tmp.isEmpty()){
				res.addAll(tmp);
			}else{
				System.out.println("Breaks on : " + i);
			}
			i++;
		}while( tmp != null && !tmp.isEmpty());
		
		
		return res;
		
	}
	
	private ArrayList<JunkPriceData> getJunkPircesByPage(int page) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParseException, InterruptedException{
		ArrayList<JunkPriceData>  r = new ArrayList<JunkPrice.JunkPriceData>();
		
		 HtmlPage htmlPage = Page.webClient.getPage(Page.mainLink+link + page);
		 HtmlElement sel;
		 DomNodeList nods;
		 HtmlTableDataCell cell;
		 String content;
		 JunkPriceData data;
		 ScriptResult rjs = htmlPage.executeJavaScript("Object.keys(auData)");
		 Object resJs = rjs.getJavaScriptResult();
		 if(resJs instanceof NativeArray){
			 NativeArray ar = (NativeArray) resJs;
			 
			 long len = ar.getLength();
			 long id;
			 for(int i = 0 ; i < len; i++){
				 data = new JunkPriceData();
				 id = Integer.valueOf(ar.get(i).toString());
				 
				 sel = htmlPage.getElementById("au_" + id);
				 nods = sel.getElementsByTagName("td");
				 
				 cell = (HtmlTableDataCell)nods.get(1);
				 content =  cell.getTextContent();
				 
				 //System.out.println(content);
				 data.qty = Integer.valueOf(content.replaceAll("Złom sztuk:", "").trim());
				 
				 
				 cell = (HtmlTableDataCell)nods.get(3);
				 content =  cell.getTextContent();
				 //System.out.println(content);
				 
				 data.price = Integer.valueOf(content.trim().replaceAll(" ", ""));
				 
				 cell = (HtmlTableDataCell)nods.get(4);
				 content =  cell.getTextContent();
				 
				 //System.out.println(content.trim().substring(0, 10));
				 
				 data.date = format.parse(content.trim().substring(0, 10));
				 
				 System.out.println(data.price + "|" + data.qty + "|" + format.format(data.date));
				r.add(data);
			 }
			 
		 }
		 Thread.sleep(1400 + generator.nextInt(1000));
		 return r;
	}
}
