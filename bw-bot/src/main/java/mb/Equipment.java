package mb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Equipment {

	ArrayList<Item> items;

	public Equipment() {
		try {
			refresh();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Item> getItemByShelf(int shelfNr){
		ArrayList<Item> res = new ArrayList<Item>();
		
		for(Item  i : items){
			if(i.getShelfNr() == shelfNr)
				res.add(i);
		}
		
		return res;
	}
	
	

	public void refresh() throws IOException {
		items = new ArrayList<Item>();
		HtmlPage current = Page.page;
		HtmlAnchor anchor = current.getAnchorByHref("?a=equip");
		current = anchor.click();
		Page.page = current;

		HtmlElement el;
		List<HtmlElement> itemList;
		Iterator<HtmlElement> detailIter;
		HtmlElement v;
		HtmlElement v2;
		HtmlElement v3;
		Item item = new Item();
		String itemName;
		int itemPrice;
		String itemSellJs;

		for (int polkaNr = 0; polkaNr < 10; polkaNr++) {
			if(polkaNr == 10){
				el = current.getElementById("hc_c" + polkaNr);
				if (el != null) {
	
					itemList = el.getElementsByAttribute("div", "class", "item");
	
					for (HtmlElement itemEl : itemList) {
						item = new Item();
						v = itemEl.getChildElements().iterator().next()
								.getChildElements().iterator().next()
								.getChildElements().iterator().next()
								.getChildElements().iterator().next()
								.getChildElements().iterator().next();
	
						v2 = v.getElementsByAttribute("div", "align", "center")
								.get(0);
	
						itemName = v2.getTextContent();
						System.out.println(itemName);
	
						v2 = v.getElementsByAttribute("table", "cellspacing", "0")
								.get(0);
						detailIter = v2.getChildElements().iterator().next()
								.getChildElements().iterator().next()
								.getChildElements().iterator();
						detailIter.next();
						v2 = detailIter.next();
						v3 = v2.getElementsByTagName("span").get(0);
						itemSellJs = v3.getAttribute("onclick").split("return")[1];
						
						System.out.println(itemSellJs);
						
						v3 = v2.getElementsByTagName("b").get(0);
						itemPrice = Integer.parseInt(v3.getTextContent().split(" PLN")[0].replaceAll(" ", ""));
						
						System.out.println(itemPrice);
						
						item.setName(itemName);
						item.setPrice(itemPrice);
						item.setSellJs(itemSellJs);
						item.setShelfNr(polkaNr + 1);
						items.add(item);
					}
				}
			}
		}

	}

}
