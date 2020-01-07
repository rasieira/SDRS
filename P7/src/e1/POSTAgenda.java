package e1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;


public class POSTAgenda {

	public static void main(String[] args)
	{
		try
		{
			URL u = new URL("http://localhost:8080/TelephoneList");
			java.net.URLConnection con = u.openConnection();
			con.setDoOutput(true);
			con.addRequestProperty("Content-Type", "text/xml");
			
			OutputStream out = con.getOutputStream();
			String datos ="<person><name>Celia</name><tphn>222</tphn></person>";
			
			out.write(datos.getBytes());
			con.getInputStream();
			out.close();
		}
		catch(IOException e) { }
	}

}
