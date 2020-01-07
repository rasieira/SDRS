package e2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.Date;

import sun.net.www.URLConnection;

public class Handler implements Runnable
{
	private String HOMEDIR = "public_html";
	private Socket S = null;
	
	public Handler(Socket S)
	{
		this.S = S;
	}
	
	@SuppressWarnings("deprecation")
	public void run()
	{
		try
		{
			DataInputStream in = new DataInputStream(S.getInputStream());
			DataOutputStream out = new DataOutputStream(S.getOutputStream());
			
			String firstLine = in.readLine();
			
			if(!(firstLine.startsWith("HEAD ") || firstLine.startsWith("GET ")))
			{
				out.writeBytes(makeHTMLErrorText(501,"Not implemented"));
				out.flush();
				return;
			}
			
			File F = buscarFichero(firstLine);
			
			String line = in.readLine();
			while(!line.startsWith("Range") && !line.equals(""))
			{
				line = in.readLine();
			}
			
			if(F.exists() && F.isFile())
			{
				RandomAccessFile raf = new RandomAccessFile(F,"r");
				String ctype=(F.getName().endsWith(".css"))?"text/css":URLConnection.guessContentTypeFromName(F.getName());
				sendMIMEHeading(S.getOutputStream(),200,ctype,F.length());
				
				S.getOutputStream().flush();
				if(firstLine.startsWith("GET "))
				{
					if(line.startsWith("Range"))
					{
						int from = Integer.parseInt(line.substring(line.indexOf("=")+1, line.indexOf("-")));
						int to = Integer.parseInt(line.substring(line.indexOf("-")+1));
						byte[] buffer = new byte[to-from+1];
						
						raf.seek(from);
						raf.readFully(buffer, 0, (to-from+1));
						S.getOutputStream().write(buffer, 0, to-from+1);
					}
					else
					{
						byte[] buffer = new byte[(int)(F.length())];
						raf.readFully(buffer);
						S.getOutputStream().write(buffer);
					}
					S.getOutputStream().flush();
				}
				raf.close();
				S.shutdownOutput();
			}
			else
			{
				out.writeBytes(makeHTMLErrorText(400,"File Not Found"));
				out.flush();
				return;
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			return;
		}
	}
	
	private File buscarFichero(String m)
	{
		String fileName="";
		if(m.startsWith("GET "))
		{
			fileName = m.substring(4, m.indexOf(" ", 5));
			if(fileName.equals("/"))
			{
				fileName = fileName + "index.html";
			}
		}
		
		if(m.startsWith("HEAD "))
		{
			fileName = m.substring(6, m.indexOf(" ", 7));
			if(fileName.equals("/"))
			{
				fileName = fileName + "index.html";
			}
		}
		
		return new File(HOMEDIR, fileName);
	}
	
	private void sendMIMEHeading(OutputStream os, int code, String cType, long fSize)
	{
		PrintStream dos = new PrintStream(os);
		
		dos.println("HTTP/1.1 "+code + " ");
		switch(code)
		{
			case 200:
				dos.print("OK\r\n");
				dos.print("Date: " + new Date() + "\r\n");
				dos.print("Server: Cutre http Server ver. -5.0\r\n");
				dos.print("Connection: close\r\n");
				dos.print("Content-length: " + fSize + "\r\n");
				dos.print("Content-type: " + cType + "\r\n");
				dos.print("\r\n");
			break;
			
			case 404:
				dos.print("File Not Found\r\n");
				dos.print("Date: " + new Date() + "\r\n");
				dos.print("Server: Cutre http Server ver. -5.0\r\n");
				dos.print("Connection: close\r\n");
				dos.print("Content-length: " + fSize + "\r\n");
				dos.print("Content-type: " + "text/html" + "\r\n");
				dos.print("\r\n");
			break;
			
			case 501:
				dos.print("Not Implemented\r\n");
				dos.print("Date: " + new Date() + "\r\n");
				dos.print("Server: Cutre http Server ver. -5.0\r\n");
				dos.print("Connection: close\r\n");
				dos.print("Content-length: " + fSize + "\r\n");
				dos.print("Content-type: " + "text/html" + "\r\n");
				dos.print("\r\n");
			break;
		}
		dos.flush();
	}
	
	private String makeHTMLErrorText(int code, String txt)
	{
		StringBuffer msg = new StringBuffer("<HTML>\r\n");
		msg.append(" <HEAD>\r\n");
		msg.append(" <TITLE>" + txt + "</TITLE>\r\n");
		msg.append(" </HEAD>\r\n");
		msg.append(" <BODY>\r\n");
		msg.append(" <H1>HTTP Error " + code + ": " + txt + "</H1>\r\n");
		msg.append(" </BODY>\r\n");
		msg.append("</HTML>\r\n");
		return msg.toString();
	}
}
