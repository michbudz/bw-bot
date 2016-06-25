package mb;

import java.io.IOException;
import java.net.MalformedURLException;

import mb.exception.LoginException;
import mb.exception.LoginException.TYPE;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class Login {

	private String login;
	private String haslo;
	private Integer server;
        
	
	ProxyConfig proxyConfig;
	
	public Login(String l, String h, Integer s) {
		this.login = l;
		this.haslo = h;
		this.server = s;
	}
	
/*	public Login(String l, String h, Integer s ,ProxyConfig p )
	{
		this.login = l;
		this.haslo = h;
		this.server = s;
	}*/

	public void  login() throws LoginException, FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException   {

		HtmlPage page = Page.webClient.getPage("http://www.bloodwars.pl/");
                

		final HtmlForm form = page.getFormByName("formularz");
		final HtmlSubmitInput button = form.getInputByName("submit");
		final HtmlTextInput login = form.getInputByName("loginname");
		final HtmlPasswordInput haslo = form.getInputByName("passwd");
		final HtmlSelect serv = form.getElementById("realm");
		final HtmlOption option = serv.getOption(this.server);
		serv.setSelectedAttribute(option, true);

		login.setValueAttribute(this.login);
		haslo.setValueAttribute(this.haslo);

		final HtmlPage page2 = button.click();             

                Thread.sleep(1000);
		HtmlElement ref = page2.getElementById("reflink");
		if(ref==null)
		{
			System.out.println("text : " + page2.asText());
			// nie uda�o sie zalogowa�
			throw new LoginException(TYPE.NIE_ZALOGOWANO);

		}
                
                Page.mainLink="http://r"+this.server+".bloodwars.interia.pl/";
                Page.page=page2;

	}

}
