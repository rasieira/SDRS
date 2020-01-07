package e4;

import java.io.*;

public class Principal
{
	public static void main(String[] args)
	{
		apartado2("ISO-8859-1");
	}
	
	public static void apartado1(String codificacion)
	{
		try(OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new File("doc/e4.txt")),codificacion))
		{
			out.write("Lápiz 1€");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void apartado2(String codificacion)
	{
		//Manera 1
		try(DataInputStream in = new DataInputStream(new FileInputStream("doc/e4.txt")))
		{
			String linea = "";
			while((linea = in.readLine()) != null)
			{
				System.out.println(linea);
				linea = in.readLine();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//Manera 2 y 3
		try(OutputStreamWriter writer = new OutputStreamWriter(System.out);
			InputStream in = new FileInputStream("doc/e4.txt");
			InputStreamReader reader = new InputStreamReader(in,codificacion))
		{
			char [] buffer = new char[100];
			int leidos = reader.read(buffer);
			
			while(leidos != -1)
			{
				writer.write(buffer, 0, leidos);
				leidos = reader.read(buffer);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
