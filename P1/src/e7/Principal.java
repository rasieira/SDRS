package e7;

import java.io.*;
import java.util.*;

public class Principal
{
	public static void main(String[] args)
	{
		List<String[]> lineas = new LinkedList<>();
		int parametros = 0;
		int blancos = 0;
		int otros = 0;
		
		try(InputStreamReader fr = new InputStreamReader(new FileInputStream("doc/misConfiguraciones.txt"),"UTF-8");
			BufferedReader in = new BufferedReader(fr);)
		{
			String linea = in.readLine();
			String[] registro = null; 
			
			while(linea != null)
			{
				registro = new String[2];
				registro[0] = linea;
				lineas.add(registro);
				linea = in.readLine();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		for(String[] registro: lineas)
		{
			if(registro[0].matches("<.*>:<.*>"))
			{
				registro[1] = "parametro";
				if(registro[0].contains("iniciales")) registro[0] = registro[0].replaceFirst(":<.*>", ":<PMG>");
			}
			else if(registro[0].equals(""))
			{
				registro[1] = "blanco";
			}
			else registro[1] = "otro";
		}
		
		try(FileWriter fw = new FileWriter("doc/misConfiguraciones.txt");
			BufferedWriter out = new BufferedWriter(fw))
		{
			for (String[] registro: lineas)
			{
				if(registro[1].equals("parametro"))
				{
					parametros++;
					out.write(registro[0]);
					out.newLine();
				}
				else if(registro[1].equals("blanco"))
				{
					blancos++;
					out.newLine();
				}
				else if(registro[1].equals("otro"))
				{
					otros++;
					out.write(registro[0]);
					out.newLine();
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(parametros);
		System.out.println(blancos);
		System.out.println(otros);
	}

}
