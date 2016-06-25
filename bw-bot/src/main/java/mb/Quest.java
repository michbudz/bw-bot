package mb;

import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.Iterator;

import mb.AccountConfig.RASA;
import mb.exception.BWException;
import mb.exception.NoMoneyException;
import mb.exception.NoQuestException;

public class Quest implements RunActionInterface{

    public String getName() {
        return "Wyprawa lvl: "+ lvl;
    }

	public enum STOPIEN {
		LATWY, NORMALNY, TRUDNY
	};

	 
        private long questTime;
        private Integer questCost;
        private STOPIEN lvl;

	public Quest(STOPIEN s) {
		lvl =s;
	}


        public void run() throws BWException {
            goToQuest();
        }
        
        public long getTime(){
            return getQuestTime();
        }
        
	public long goToQuest() throws BWException {
		try {
			Equipment eq = new Equipment();
            HtmlPage current = Page.page;
			HtmlAnchor anchor = current.getAnchorByHref("?a=quest");
			//AccountConfigFactory.getInstance().loadProperty();
			
			current= anchor.click();
			HtmlDivision stWypr = null;
			if (lvl==STOPIEN.LATWY) {
				stWypr = (HtmlDivision) current.getElementById("questDiff_0");
			} else if (lvl==STOPIEN.NORMALNY) {
				stWypr = (HtmlDivision) current.getElementById("questDiff_1");
			} else if (lvl==STOPIEN.TRUDNY) {
				stWypr = (HtmlDivision) current.getElementById("questDiff_2");
			}
                        if(stWypr == null)
                            throw new NoQuestException();
                        setMaxArcane(current);
                        
			stWypr.click();
                        getTimeAndCost(stWypr);
                        AccountConfig conf = AccountConfigFactory.getInstance();
                        
                        
                        if(conf.getQuest()<=0)
                            throw new NoQuestException();
                        else if(conf.getMoney()-this.questCost<0)
                            throw new NoMoneyException();
                        
                        Shop shop = new Shop();
                        Item qi = shop.getQuestItem();
                        
                        SellJunk sell = new SellJunk();
                    	
                        if(qi != null && conf.getMoney() < qi.getPrice()){
                        	sell.sell(eq, conf.getJunkShelf(), qi.getPrice() - conf.getMoney());
                        	shop.buyItem(qi);
                        }
                        
                        if(conf.getMoney() < questCost){
                        	sell.sell(eq, conf.getJunkShelf(), questCost - conf.getMoney());
                        }
                        
                        conf.decMoney(questCost);
                        conf.DecQuest();
                        
                        HtmlForm wyprawa = current.getFormByName("questForm");
			HtmlSubmitInput startQ = wyprawa.getInputByName("submit");
			HtmlPage page3 = startQ.click();
			System.out.println("text : " + page3.asText());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;

	}
        
        private void setMaxArcane(HtmlPage page)
        {
            AccountConfig conf = AccountConfigFactory.getInstance();
            if(conf.getRasa() == RASA.KULTYSTA)
            {
              page.executeJavaScript("clickMax(5);");
      
            }else if(conf.getRasa() == RASA.POTEPION)
            {
               page.executeJavaScript("clickMax(13);"); 
            }
                    
        }
        
        private void getTimeAndCost(HtmlDivision stWypr)
        {
            Iterator<HtmlElement> elList= stWypr.getChildElements().iterator(); 
            elList.next();
            elList=  elList.next().getChildElements().iterator(); // stype= positive
            elList= elList.next().getChildElements().iterator();
            HtmlElement tmp = elList.next(); // czas
            String[] ts=  tmp.asText().split(" ");
            Integer czas;

            if(ts.length>2) // jeśli czas = 1 min i 40 s
            {
                System.out.println(" czaas : "+ Integer.parseInt(ts[2]));
                czas =( Integer.parseInt(ts[0])* 60 * 1000 + Integer.parseInt(ts[2]) * 1000);

            }else // jeśli czas = 30 min
            {
                czas =( Integer.parseInt(ts[0])* 60 * 1000 ); 
            }
            System.out.println(" czas : " + czas);
            this.questTime=czas.longValue();
            elList.next();
            tmp =elList.next(); // koszt
            elList=   tmp.getChildElements().iterator();
            tmp = elList.next();
            ts =  tmp.asText().split(" ");
            Integer koszt = Integer.parseInt(ts[0]);
            this.questCost= koszt;
           
        }
                
	
	private boolean checkQuestAvailable()
	{
		
		return true;
	}
	
	private boolean checkMoneyAvailable()
	{
		return true;
	}

    public long getQuestCost() {
        return questCost;
    }

    public long getQuestTime() {
        return questTime;
    }
        
        
}
