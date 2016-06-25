package mb;


import java.net.MalformedURLException;
import mb.exception.LoginException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import mb.Quest.STOPIEN;
import mb.exception.BWException;
import mb.exception.NoMoneyException;
import mb.queue.Queue;
import mb.queue.QueueElement;
import objectexplorer.ObjectGraphMeasurer;
import org.apache.commons.logging.LogFactory;

public class test  {

	public void ValidateHomePage() throws Exception {
		
	}
 
	/**
	 * @param args
	 */
        /* 
	public static void main(String[] args) {
                
                    
		try {
                     LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
 
                    AccountConfigFactory.createInstance("user.properties");
                    System.out.println(ObjectGraphMeasurer.measure("2 : "+AccountConfigFactory.getInstance()));
                    AccountConfig conf= AccountConfigFactory.getInstance();
                    System.out.println(" test :" + conf.getLogin() +  ":" + conf.getPass()+":"+conf.getServ());
                    Login log = new Login(conf.getLogin(), conf.getPass(), conf.getServ());
                    log.login();
                
                    //Opponent op = new Opponent("?a=profile&uid=1485");
                    
                    
                  
                    AccountConfigFactory.getInstance().loadWebProperty();
                     System.out.println(ObjectGraphMeasurer.measure("4: "+AccountConfigFactory.getInstance()));
                   
                     Quest t = new Quest(STOPIEN.LATWY);
                     Quest t2 = new Quest(STOPIEN.LATWY);
                    Queue q = new Queue();
                     System.out.println(ObjectGraphMeasurer.measure("q: "+q));
                    q.add(new QueueElement(t));
                    q.add(new QueueElement(t2));
                    q.execute();
                    System.out.println(ObjectGraphMeasurer.measure("q2: "+q));
                    
                    
                } catch (BWException ex) {
                    Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                
		} catch (IOException ex) {
                    Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                             Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		}
		//
		// Quest quest = new Quest(currPage);
		// currPage = quest.goToQuest(STOPIEN.TRUDNY);

		// test tmp = new test();
		// tmp.ValidateHomePage();

                     
                     
	}
*/
}
