package e1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.*;

public class Unirioja {

	public static void main(String[] args) throws IOException
	{
		String privateKey ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTZWRlIEFQSSIsInJvbGVzIjoidXNlciIsImlhdCI6MTU0NjAwODc0MywianRpIjoiMmY3ODM2NzUtMGFiMC0xMWU5LWEyZTItNTUwZDcyMmE2MzhiIn0.rri2hrjEic7bC1VPoHh8PlRbK4w7NyEyEpIdiWkTuxY";
		System.setProperty("javax.net.ssl.trustStore","C:\\Users\\pamendoz\\Desktop\\CA");
		
		URL base = new URL("https://sede.unirioja.es/api/estudiantes/me");
		
		HttpsURLConnection C = (HttpsURLConnection) base.openConnection();
		C.setRequestProperty("Authorization", "Bearer "+privateKey);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(C.getInputStream()));
		
		StringBuilder sB = new StringBuilder();
		String linea = in.readLine();
		while(linea != null)
		{
			sB.append(linea);
			linea = in.readLine();
		}
		
		String json = sB.toString();
		JSONObject response = new JSONObject(json);
		for(String S: response.keySet())
		{
			System.out.println(response.get(S));
		}
		C.disconnect();
	}

}
