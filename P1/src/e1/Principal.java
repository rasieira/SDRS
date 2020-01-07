package e1;
import java.io.*;
public class Principal
{
	public static void main(String[] args)
	{
		try(BufferedReader in = new BufferedReader(new FileReader(args[0])))
		{
			String linea = in.readLine();
			int contador = 0;
			int cortar = 0;
			while(linea != null)
			{
				while((cortar = linea.indexOf(args[1])) != -1)
				{
					linea = linea.substring(cortar + args[1].length());
					contador++;
				}
				linea = in.readLine();
			}
			System.out.println(contador);
		}
		catch(IOException e)
		{
			System.out.println("No se puede localizar el fichero");
		}
	}
}
