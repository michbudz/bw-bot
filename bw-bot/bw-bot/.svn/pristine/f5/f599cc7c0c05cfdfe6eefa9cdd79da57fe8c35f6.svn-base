package mb;

public class AccountConfigFactory {
	
	private static AccountConfig accountConfig;
	private static String file;
        
        public static void createInstance(String n)
        {
            file =n;
            accountConfig = new AccountConfig(n);
        }
        
        
	public synchronized static AccountConfig getInstance()
	{
          
		if(accountConfig==null)
		{
			accountConfig = new AccountConfig(file);
		}

           return accountConfig;
	}
	
	
}
