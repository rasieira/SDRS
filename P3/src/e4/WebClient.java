package e4;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

public class WebClient
{
	private String host;
	private int puerto;
	
	public WebClient(String host, int puerto)
	{
		this.puerto = puerto;
		this.host = host;
	}
	
	public void descargarSinGuardar()
	{
		try(Socket s = new Socket(host,puerto);
			BufferedInputStream in = new BufferedInputStream(s.getInputStream());
			ByteArrayOutputStream file_in_buffer = new ByteArrayOutputStream())
		{
			byte[] buffer = new byte[2^20];
			int leidos = in.read(buffer);
			while(leidos != -1)
			{
				file_in_buffer.write(buffer);
				leidos = in.read(buffer);
			}
			System.out.println("");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args)
//	{
//		WebClient c1 = new WebClient("localhost",6666);
//		c1.descargarSinGuardar();
//	}
}
