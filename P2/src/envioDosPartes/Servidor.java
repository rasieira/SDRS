package envioDosPartes;
import java.io.*;
import java.net.*;
public class Servidor
{
	public static void main(String[] args)
	{
		FileOutputStream file_output = null;
		try
		(
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			InputStream is = s.getInputStream();
			//InputStreamReader isr = new InputStreamReader(s.getInputStream());
			DataInputStream dis = new DataInputStream(is);
			//BufferedReader reader = new BufferedReader(isr);
		)
		{
			long filesize = Long.parseLong(dis.readLine());
			String canonical_path = dis.readLine();
			
			file_output = new FileOutputStream(canonical_path+"_received");
			
			int read_total = 0;
			
			while(read_total<filesize/2)
			{
				file_output.write(is.read());
				read_total++;
			}
			System.out.println(dis.readLine());
			
			int readbyte;
			while((readbyte = is.read()) != -1)
			{
				file_output.write(readbyte);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(file_output != null)
				try {
					file_output.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
	}
}
