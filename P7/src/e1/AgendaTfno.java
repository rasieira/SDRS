package e1;

import java.util.Hashtable;
import java.util.Map;

public class AgendaTfno
{
	protected static Map<String,Persona> agenda = new Hashtable<>();
	
	public void aniadeTfno(Persona p)
	{
		agenda.put(p.getNombre(), p);
	}
	
	public void aniadeTfno(String nombre, String tfno)
	{
		this.aniadeTfno(new Persona(nombre,tfno));
	}
	
	public String getTfno(String nombre)
	{
		Persona p = agenda.get(nombre);
		return p != null ? p.getTfno(): null;
	}
}
