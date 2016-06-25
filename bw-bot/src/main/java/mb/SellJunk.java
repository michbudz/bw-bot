package mb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class SellJunk{

	
	public SellJunk() {
	}

	public void sell(Equipment eq, int shelfNr, int needMoney) throws IOException, InterruptedException{
		
		ArrayList<Item> items = eq.getItemByShelf(shelfNr);
		Collections.sort(items, new ItemPriceComparator());
		
		HtmlPage current = Page.page;
		HtmlAnchor anchor = current.getAnchorByHref("?a=equip");
		current = anchor.click();
		
		int sold = 0;
		ScriptResult resultJs;
		for(Item i : items){
			resultJs = current.executeJavaScript(i.getSellJs());
			Thread.sleep(1550);
			sold += i.getPrice();
			if(sold >= needMoney){
				AccountConfigFactory.getInstance().incMoney(sold);
				eq.refresh();
				
				return;
			}
		}
		
	}
}
