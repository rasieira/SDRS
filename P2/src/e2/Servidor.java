package e2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class Servidor
{
	private static AgendaTfno agenda = new AgendaTfno();

	public static void main(String[] args)
	{
		ServerSocket ss = null;
		try
		{
			ss = new ServerSocket(6666);
		} catch (IOException e)
		{
			e.printStackTrace();
			return;
		}

		while (true)
		{
			try (Socket s = ss.accept();
					BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));)
			{
				String request = in.readLine();

				String[] request_array = request.split(" ");
				if ((request_array.length != 3 && request_array.length != 2)
						|| (!request_array[0].equals("PUT") && !request_array[0].equals("GET")))
				{
					out.write("ERROR\r\n");
					out.flush();
					throw new IllegalArgumentException("Formato de mensaje incorrecto");
				}

				if (request_array[0].equals("GET"))
				{
					String tfno;
					if ((tfno = agenda.getTfno(request_array[1])) == null)
					{
						out.write("Desconocido\r\n");
						out.flush();
					} else
					{
						out.write(tfno + "\r\n");
						out.flush();
					}
				} else
				{
					agenda.anadeTelefono(request_array[1], request_array[2]);
					out.write("OK\r\n");
					out.flush();
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			} catch (IllegalArgumentException e2)
			{
				e2.printStackTrace();
			}
		}

	}

}
