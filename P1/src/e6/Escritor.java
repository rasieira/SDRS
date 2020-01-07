package e6;
import java.io.*;

public class Escritor
{
	public static void main(String[] args)
	{
		Contactos C = new Contactos();
		C.addDatos("Manolito Gafotas", "112", "manolito87@terra.es");
		
		try(OutputStream os = new FileOutputStream("doc/contactos");
			ObjectOutputStream out = new ObjectOutputStream(os))
		{
			out.writeObject(C);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
