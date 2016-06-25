package mb.htmlunit;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ElementBy {
		
		public static List<HtmlElement> getElementsByTagAndClass(HtmlPage page, String tag, String className){
			 	List<HtmlElement> res = new ArrayList<HtmlElement>();
		       List<HtmlElement> elementsByTag = page.getElementsByTagName(tag);

		       for (HtmlElement element : elementsByTag) {

		           if (className.equalsIgnoreCase(element.getAttribute("class"))){
		        	   res.add(element);
		           }
		       }
		       return res;
		   }
	
	   public static  HtmlElement getElementByTagAndClass(HtmlPage page, String tag, String className){

	       List<HtmlElement> elementsByTag = page.getElementsByTagName(tag);

	       for (HtmlElement element : elementsByTag) {

	           if (className.equalsIgnoreCase(element.getAttribute("class"))){

	               return element;
	           }
	       }
	       return null;
	   }
	   
	   public static  HtmlElement getElementByTagAndStyle(HtmlPage page, String tag, String style){

	       List<HtmlElement> elementsByTag = page.getElementsByTagName(tag);

	       for (HtmlElement element : elementsByTag) {

	           if (style.equalsIgnoreCase(element.getAttribute("style"))){

	               return element;
	           }
	       }
	       return null;
	   }
}
