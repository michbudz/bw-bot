/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 *
 * @author xxx
 */
public class Page {
    
    public static String mainLink;
    public static HtmlPage page;
    public static WebClient webClient= new WebClient(BrowserVersion.FIREFOX_3_6);
    

   static {
		webClient.setJavaScriptEnabled(true);
		// client.setAjaxController(new NicelyResynchronizingAjaxController());
		webClient.setThrowExceptionOnScriptError(false);
		webClient.waitForBackgroundJavaScriptStartingBefore(60000);

    }
 
    
}
