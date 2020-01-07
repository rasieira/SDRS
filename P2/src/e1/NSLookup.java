package e1;
import java.net.*;
public class NSLookup
{
	public static void main(String[] args) throws UnknownHostException
	{
		if(args.length != 1) throw new IllegalArgumentException("Numero incorrecto de parametros");
		InetAddress IP = InetAddress.getByName(args[0]);
		if(isIPAddress(args[0]))
		{
			System.out.println(IP.getCanonicalHostName());
		}
		else
		{
			System.out.println(IP.getHostAddress());
		}
	}
	
	private static boolean isIPAddress(String in)
	{
		String [] in_splitted = in.split("\\.");
		
		for(int i = 0;i<in_splitted.length;i++)
		{
			try
			{
				int N = Integer.parseInt(in_splitted[1]);
				if(N>255 || N<0) return false;
				
			}
			catch(NumberFormatException e)
			{
				return false;
			}
		}
		
		return true;
	}
}
