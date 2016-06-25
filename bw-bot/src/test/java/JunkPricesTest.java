import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import mb.AccountConfig;
import mb.AccountConfigFactory;
import mb.JunkPrice;
import mb.JunkPrice.JunkPriceData;
import mb.Login;
import mb.exception.LoginException;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;


public class JunkPricesTest {
	public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws LoginException, FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException, ParseException {
		


	 LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
	 
    AccountConfigFactory.createInstance("user.properties");
    AccountConfig conf= AccountConfigFactory.getInstance();
    System.out.println(" test :" + conf.getLogin() +  ":" + conf.getPass()+":"+conf.getServ());
    Login log = new Login(conf.getLogin(), conf.getPass(), conf.getServ());
    log.login();
    
    
    JunkPrice price = new JunkPrice();
    
    ArrayList<JunkPriceData>  res = price.getAllJunkPrices(1);
    PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
    for(JunkPriceData d : res){
    	writer.println( d.price + "|" + d.qty + "|" + format.format(d.date)) ;
    }
    writer.close();
	}

}
