package Utils;

import java.util.Date;

public class CommonUtils {

	public String generateBrandNewEmail() {
		Date date = new Date();
		  
		  String email = date.toString().replace(" ", "").replace(":", "")+"@gmail.com";			  
				  
		  return email;		
		


	}

}
