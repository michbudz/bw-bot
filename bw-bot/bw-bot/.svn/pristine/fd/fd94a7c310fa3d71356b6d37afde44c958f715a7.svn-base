/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import mb.AccountConfig.RASA;
import mb.htmlunit.ElementBy;

/**
 *
 * @author xxx
 */
public class Opponent {
    
    public enum STATUS{ROWNY , SILNIEJSZY , SLABSZY};
    private String nick;
    private String link;
    private Integer wins;
    private Integer draws;
    private AccountConfig.RASA race;
    private Integer points;
    private Integer lvl;
    private String clan;
    private Integer ranking;
    private STATUS status;
    private boolean available;
    
    public Opponent(String l)
    {
        this.link=l;
        loadProperty();
        
    }
    
    private void loadProperty()
    {
        try {
            HtmlPage page = Page.webClient.getPage(Page.mainLink+link);
            System.out.println(page.asText());
            
           HtmlElement o = ElementBy.getElementByTagAndClass(page , "fieldset" , "profile"); 
           Iterator<HtmlElement> tabelaEl=o.getChildElements().iterator();
           tabelaEl.next();
           tabelaEl= tabelaEl.next().getChildElements().iterator(); // elementy tabeli
          
           Iterator<HtmlElement> wiersz=tabelaEl.next().getChildElements().iterator();
           Iterator<HtmlElement> kolumna= wiersz.next().getChildElements().iterator();

           kolumna.next();
           String rasa = kolumna.next().asText().trim();
            System.out.println("RASA : " + rasa);
            if( rasa.equals("KULTYSTA"))
            {
                this.race=AccountConfig.RASA.KULTYSTA;
            } else if(rasa.equals("POTĘPIONY") )
            {
                this.race=AccountConfig.RASA.POTEPION;     
            }else if(rasa.equals("ŁAPACZ MYŚLI") )
            {
                this.race=AccountConfig.RASA.LAPACZ_MYSLI; 
            }else if(rasa.equals("WŁADCA ZWIERZĄT"))
            {
                this.race=AccountConfig.RASA.WLADCA_ZWIERZAT; 
            }else if(rasa.equals("SSAK"))
            {
                this.race=AccountConfig.RASA.SSAK; 
            }
            
            wiersz.next(); //plec
            wiersz.next(); // adres
            kolumna= wiersz.next().getChildElements().iterator(); // klan
            kolumna.next();
            String klan = kolumna.next().asText().trim();
            System.out.println("klan : " + klan);
            this.clan=klan;
            
            wiersz.next();
            kolumna= wiersz.next().getChildElements().iterator(); // poziom
            kolumna.next();
            String poziom = kolumna.next().asText().trim();
            System.out.println("poziom : " + poziom);
            this.lvl=Integer.parseInt(poziom);
            
            kolumna= wiersz.next().getChildElements().iterator(); // punkty
            kolumna.next();
            String punkty = kolumna.next().asText().trim();
            System.out.println("pkt : " + punkty);
            this.points=Integer.parseInt(punkty);
            
            kolumna= wiersz.next().getChildElements().iterator(); // ranking
            kolumna.next();
            String ranking = (kolumna.next().asText().trim().split(" "))[0];
            
            System.out.println("ranking : " + ranking);
            this.ranking=Integer.parseInt(ranking);
            
            kolumna= wiersz.next().getChildElements().iterator(); // STATUS    
            kolumna.next();
            String status = kolumna.next().asText().trim();
            System.out.println("status : " + status);
            if(status.equals("RÓWNY"))
                this.status=STATUS.ROWNY;
            else if(status.equals("SŁABSZY"))
                this.status=STATUS.SLABSZY;
            else if(status.equals("SILNIEJSZY"))
                this.status=STATUS.SILNIEJSZY;

  
            
        } catch (IOException ex) {
            Logger.getLogger(Opponent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FailingHttpStatusCodeException ex) {
            Logger.getLogger(Opponent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public RASA getRace() {
        return race;
    }

    public void setRace(RASA race) {
        this.race = race;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }
    
    
    
}
