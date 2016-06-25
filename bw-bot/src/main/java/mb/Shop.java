package mb;

import java.io.IOException;
import java.util.ArrayList;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Shop {
	
	private static String shopLink = "?a=townshop";
	
	private static ArrayList<String> oneUse = new ArrayList<String>(); 
	static {
		oneUse.add("selectCat('onetime1');");
		oneUse.add("selectCat('onetime2');");
		oneUse.add("selectCat('onetime3');");
	}
	
	ArrayList<Item> items;
	
	public Shop(){
		
	}
	
	public void buyItem(Item it){
		try {
			items = new ArrayList<Item>();
			HtmlPage current = Page.page;
			HtmlAnchor anchor = current.getAnchorByHref(shopLink);
			current = anchor.click();
			AccountConfig conf = AccountConfigFactory.getInstance();
			HtmlAnchor selected;
			for(String exe : oneUse){
				current.executeJavaScript(exe);
				
				selected = current.getAnchorByText(conf.getQuestItem());
				if(selected != null){
					
					
					
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public Item getQuestItem(){
		return null;
		
	}
}
