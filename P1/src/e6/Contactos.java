package e6;

import java.util.*;
import java.io.*;

public class Contactos implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	public int maximoContactos = 1000;
	
	public int getSize()
	{
		return agenda.size();
	}

	public class Datos implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private String email;
		private String tfno;

		public Datos(String email, String telefono)
		{
			this.email = email;
			this.tfno = telefono;
		}

		public String getTfno()
		{
			return tfno;
		}

		public String getEmail()
		{
			return email;
		}
	}

	private Map<String, Datos> agenda = new HashMap<String, Datos>();

	public void addDatos(String nombre, String tfno, String email)
	{
		agenda.put(nombre, new Datos(email, tfno));
	}

	public String getTfno(String nombre)
	{
		return agenda.get(nombre).getTfno();
	}

	public String getEmail(String nombre)
	{
		return agenda.get(nombre).getEmail();
	}
}
