package e2;

import java.io.*;

public class Principal
{
	public static void main(String[] args) throws IllegalArgumentException
	{
		if(args.length != 2) throw new IllegalArgumentException("Numero invalido de argumentos");
		
		byte[] buffer_in = new byte[500];
		
		try(InputStream in = new FileInputStream(args[0]);
			OutputStream out = new FileOutputStream(args[1]))
		{
			int leidos = 0;
			while((leidos = (in.read(buffer_in))) != -1)
			{
				out.write(buffer_in,0,leidos);
				leidos = in.read(buffer_in);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Alguno de los archivos no pudo ser abierto");
		}
	}
}
