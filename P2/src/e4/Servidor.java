package e4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;

public class Servidor
{
	public static void main(String[] args)
	{
		ServerSocket ss = null;
		try
		{
			ss = new ServerSocket(6666);
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		while (true)
		{
			try (Socket s = ss.accept();
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
					BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream())))
			{
				String[][] buffer = new String[500][2];
				int i = 0;
				String line = reader.readLine();
				while (!line.equals("*"))
				{
					buffer[i][0] = line;
					buffer[i][1] = new Timestamp(System.currentTimeMillis()).toString();
					i++;
					line = reader.readLine();
				}

				for (int j = 0; j < i; j++)
				{
					writer.write("Echo server at "+InetAddress.getLocalHost().getHostAddress()+" ["+buffer[j][1]+"]: "+buffer[j][0]);
					writer.newLine();
				}
				writer.flush();

			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
