package mb;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import mb.Quest.STOPIEN;
import mb.exception.BWException;
import mb.queue.Queue;
import mb.queue.QueueElement;

//import objectexplorer.ObjectGraphMeasurer;
import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class test  {

	public void ValidateHomePage() throws Exception {
		
	}
 
	/**
	 * @param args
	 */
        
	public static void main(String[] args) {
                
                    
		try {
                     LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
 
                    AccountConfigFactory.createInstance("user.properties");
                    AccountConfig conf= AccountConfigFactory.getInstance();
                    System.out.println(" test :" + conf.getLogin() +  ":" + conf.getPass()+":"+conf.getServ());
                    Login log = new Login(conf.getLogin(), conf.getPass(), conf.getServ());
                    log.login();
                
                    //Opponent op = new Opponent("?a=profile&uid=1485");
                    
                    
                  
                    AccountConfigFactory.getInstance().loadWebProperty();
                     Quest t = new Quest(STOPIEN.LATWY);
                     Quest t2 = new Quest(STOPIEN.LATWY);
                     //Equipment eq = new Equipment();
                    // SellJunk junk  = new SellJunk();
                     //junk.sell(eq, conf.getJunkShelf(), 5000);
                     
                    Queue q = new Queue();
                    q.add(new QueueElement(t));
                    q.add(new QueueElement(t2));
                    //q.add(new QueueElement(junk));
                    q.execute();
                    
                    
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

}
