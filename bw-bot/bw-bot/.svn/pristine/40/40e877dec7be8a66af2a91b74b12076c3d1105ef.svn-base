package mb;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import java.util.Iterator;

import mb.htmlunit.ElementBy;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountConfig{
        
        private File f;
        private Properties p;
	private Integer money;
	private Integer blood;
	private Integer people;
	private Integer quest;
	private Integer attack;
	
	private RASA rasa;
	public enum RASA {KULTYSTA , POTEPION, SSAK, LAPACZ_MYSLI , WLADCA_ZWIERZAT}
	
        public AccountConfig(String file)
        {
            f= new File(file);
            p = new Properties();
            System.setProperty("file.encoding", "UTF-8");
            loadFileProperty();
        }
        
	public void DecQuest()
	{
		quest--;
	}
	
	public void DecAttack()
	{
		attack--;
	}
        
        private void loadFileProperty()
        {
             //Strumień wejściowy
                InputStream is;
                try {
                        is = new FileInputStream(f);
                        //ładujemy nasze ustawienia
                        p.load(is);
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                } 
        }
        
        public String getLogin()
        {
            return p.getProperty("login");
        }
        
        public String getPass()
        {
            return p.getProperty("password");
        }
        
        public Integer getServ()
        {
            return Integer.parseInt(p.getProperty("server"));
        }
        
        
	
	public void loadWebProperty() throws InterruptedException
	{

            
            try {
                HtmlPage page = Page.page;
		HtmlElement el;
                HtmlAnchor anchor = page.getAnchorByHref("?a=main");
                if(anchor!=null)
                {
                   page =  anchor.click();
                }
                el = page.getElementById("main-stats");
                if(el!=null)
                {
                        loadRace(el);     
                }
                
		el = ElementBy.getElementByTagAndClass(page, "div", "topstats stats-blood");
		if(el!=null)
		{
			loadBlood(el);
		}
		el = ElementBy.getElementByTagAndClass(page, "div", "topstats stats-cash");
		if(el!=null)
		{
			loadMoney(el);
		}
		el = ElementBy.getElementByTagAndClass(page, "div", "topstats stats-ppl");
		if(el!=null){
			loadPeople(el);
		}
                
                anchor = page.getAnchorByHref("?a=quest");
                page =  anchor.click();
                Thread.sleep(1000);
        
		el = ElementBy.getElementByTagAndClass(page, "span", "enabled");
		if(el!=null)
		{
			loadQuest(el);
		}
                anchor = page.getAnchorByHref("?a=ambush");
                page = anchor.click();
                Thread.sleep(1000);
                
                anchor = page.getAnchorByHref("?a=ambush&opt=atk");
                page= anchor.click();
                Thread.sleep(1000);
                
                el = ElementBy.getElementByTagAndClass(page, "span", "enabled");
                if(el!=null)
                {
                    loadAttack(el);
                }

                
            } catch (IOException ex) {
                Logger.getLogger(AccountConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}
		
                private void loadRace(HtmlElement el)
                {
                  HtmlElement tmp= el.getChildElements().iterator().next();
                  Iterator<HtmlElement> list =tmp.getChildElements().iterator();
                  list =list.next().getChildElements().iterator();
                  list.next();
             
                  tmp =list.next();
                  
                  
                  if("KULTYSTA".equals(tmp.asText().trim()))
                  {
                      this.rasa=RASA.KULTYSTA;
                  }else if("POTĘPIONY".equals(tmp.asText().trim()))
                  {
                      this.rasa=RASA.POTEPION;
                  }
                  System.out.println(" rasa : " + this.rasa);
                }
        
		private void loadBlood(HtmlElement el)
		{
			Iterator<HtmlElement> listaEl =el.getChildElements().iterator();
			HtmlElement tabela = listaEl.next();
			Iterator<HtmlElement> trEl =tabela.getChildElements().iterator();
			Iterator<HtmlElement> eleme =trEl.next().getChildElements().iterator();
			Iterator<HtmlElement> inTr =  eleme.next().getChildElements().iterator();
			HtmlElement aaa = inTr.next();
			Iterator<HtmlElement> br = inTr.next().getChildElements().iterator();
			HtmlElement inbr=  br.next();
			inbr= br.next();
			inbr= br.next();
			inbr.asText();
			Integer krew = Integer.parseInt(inbr.asText().replaceAll("\\s", ""));
			this.blood=krew;
                        System.out.println(" krwi : " + this.blood);
		}
		
		private void loadMoney(HtmlElement el)
		{
			Iterator<HtmlElement> listaEl =el.getChildElements().iterator();
			HtmlElement tabela = listaEl.next();
			Iterator<HtmlElement> trEl =tabela.getChildElements().iterator();
			Iterator<HtmlElement> eleme =trEl.next().getChildElements().iterator();
			Iterator<HtmlElement> inTr =  eleme.next().getChildElements().iterator();
			HtmlElement aaa = inTr.next();
			Iterator<HtmlElement> br = inTr.next().getChildElements().iterator();
			HtmlElement inbr=  br.next();
			inbr= br.next();
			String kasa = inbr.getNextSibling().asText();
			inbr.asXml();
			kasa= kasa.replaceAll("\\s", "");
			kasa= kasa.replaceAll("PLN", "");
			Integer mm = Integer.parseInt(kasa);
			this.money=mm;
                        System.out.println(" kasy : " + this.money);
		}
		
		private void loadPeople(HtmlElement el)
		{
			Iterator<HtmlElement> listaEl =el.getChildElements().iterator();
			HtmlElement tabela = listaEl.next();
			Iterator<HtmlElement> trEl =tabela.getChildElements().iterator();
			Iterator<HtmlElement> eleme =trEl.next().getChildElements().iterator();
			Iterator<HtmlElement> inTr =  eleme.next().getChildElements().iterator();
			HtmlElement aaa = inTr.next();
			Iterator<HtmlElement> br = inTr.next().getChildElements().iterator();
			HtmlElement inbr=  br.next();
			inbr= br.next();
			String ludzie = inbr.getNextSibling().asText();
			inbr.asXml();
			ludzie= ludzie.replaceAll("\\s", "");
			Integer mm = Integer.parseInt(ludzie);
			this.people=mm;
                        System.out.println(" ludzi : " + this.people);
		}
		
		private void loadQuest(HtmlElement el)
		{
			Iterator<HtmlElement> listaEl =el.getChildElements().iterator();                  
                        HtmlElement tmp=  listaEl.next();
                        Integer wyprawy = Integer.parseInt(tmp.asText());
                        this.quest = wyprawy;  
                        System.out.println(" wyprawy : " + this.quest);
		}
                
                private void loadAttack(HtmlElement el)
                {
                    Iterator<HtmlElement> listaEl =el.getChildElements().iterator();                  
                        HtmlElement tmp=  listaEl.next();
                        Integer ataki = Integer.parseInt(tmp.asText());
                        this.attack = ataki;  
                        System.out.println(" ataki : " + this.attack);
                }

	/**
	 * @return the money
	 */
	public Integer getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(Integer money) {
		this.money = money;
	}

	/**
	 * @return the blood
	 */
	public Integer getBlood() {
		return blood;
	}

	/**
	 * @param blood the blood to set
	 */
	public void setBlood(Integer blood) {
		this.blood = blood;
	}

	/**
	 * @return the people
	 */
	public Integer getPeople() {
		return people;
	}

	/**
	 * @param people the people to set
	 */
	public void setPeople(Integer people) {
		this.people = people;
	}

	/**
	 * @return the quest
	 */
	public Integer getQuest() {
		return quest;
	}

	/**
	 * @param quest the quest to set
	 */
	public void setQuest(Integer quest) {
		this.quest = quest;
	}

	/**
	 * @return the attack
	 */
	public Integer getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(Integer attack) {
		this.attack = attack;
	}


    public RASA getRasa() {
        return rasa;
    }

    public void setRasa(RASA rasa) {
        this.rasa = rasa;
    }
    
    public void decMoney(Integer ile)
    {
        this.money-=ile;
    }

        
        
}
