package temp;

import java.util.Date;

public class GenerateEmailDEMO {

	public static void main(String[] args) {
		
		  Date date = new Date();
		  
		 
		  String d = date.toString();
		  String k = d.replace(" ", "");
		  String m = k.replace(":", "");
		  System.out.println(m);		
		
	}
		
}
