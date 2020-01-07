package e6;

import java.io.*;

public class Lector
{

	public static void main(String[] args) throws ClassNotFoundException
	{
		try(InputStream is = new FileInputStream("doc/contactos");
			ObjectInputStream in = new ObjectInputStream(is))
		{
			Contactos C = (Contactos) in.readObject();
			System.out.println(C.getEmail("Manolito Gafotas"));
			System.out.println(C.getTfno("Manolito Gafotas"));
			System.out.println(C.maximoContactos);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
