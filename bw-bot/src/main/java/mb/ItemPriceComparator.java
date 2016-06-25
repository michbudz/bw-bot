package mb;

import java.util.Comparator;

public class ItemPriceComparator implements Comparator<Item>{

	public int compare(Item o1, Item o2) {
		if(o1 == null || o2 == null)
			return -1;
		return new Integer(o1.getPrice()).compareTo(new Integer(o2.getPrice()));
	}


}
