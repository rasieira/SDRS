package e3;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Cliente
{

	public static void main(String[] args)
	{
		if(args.length < 2 || args.length > 3) throw new IllegalArgumentException("Numero parametros incorrectos");
		String webpage = args[0];
		String port;
		if(args.length == 2)
		{
			port = "80";
		}
		else port = args[1];
		String resource;
		if(args.length == 2)
		{
			resource = args[1];
		}
		else resource = args[2];

		
		try(Socket s = new Socket(webpage,Integer.parseInt(port));
			InputStream raw_in = s.getInputStream();
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			ByteArrayOutputStream file_in_buffer = new ByteArrayOutputStream();
			FileOutputStream file_out = new FileOutputStream("media/"+resource.substring(resource.lastIndexOf('/'), resource.length())))
		{
			String request = "GET "+resource+" HTTP/1.0"+"\r\n\r\n";
			out.writeBytes(request);
			out.flush();
			
			String line = in.readLine();
			while(!line.equals(""))
			{
				line = in.readLine();
			}
			
			byte[] buffer = new byte[2^12];
			int leidos = raw_in.read(buffer);
			while(leidos != -1)
			{
				file_in_buffer.write(buffer, 0, leidos);
				leidos = raw_in.read(buffer);
			}
			
			file_out.write(file_in_buffer.toByteArray());
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(NumberFormatException e2)
		{
			e2.printStackTrace();
		}
	}

}
