import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateTest {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("2016-03-1913:23".substring(0,10));
		format.parse("2016-03-19");

	}

}
