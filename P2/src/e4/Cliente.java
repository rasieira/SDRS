package e4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente
{

	public static void main(String[] args)
	{
		try(Scanner keyboard = new Scanner(System.in);
			Socket s = new Socket("localhost",6666);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream())))
		{
			String line = keyboard.nextLine();
			while(!line.equals("*"))
			{
				writer.write(line);
				writer.newLine();
				line = keyboard.nextLine();
			}
			writer.write(line);
			writer.newLine();
			writer.flush();
			
			line = reader.readLine();
			while(line != null)
			{
				System.out.println(line);
				line = reader.readLine();
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
