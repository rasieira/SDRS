package e2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Cliente
{

	public static void main(String[] args)
	{
		if (args.length == 0 || args.length > 2)
			throw new IllegalArgumentException("Numero parametros incorrecto");

		try (Socket s = new Socket("localhost", 6666);
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));)
		{
			if (args.length == 1)
			{
				out.write("GET " + args[0] + "\r\n");
				out.flush();
				System.out.println(in.readLine());
			} else
			{
				out.write("PUT " + args[0] + " " + args[1] + "\r\n");
				out.flush();
				System.out.println(in.readLine());
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
