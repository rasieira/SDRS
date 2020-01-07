package e2;

import java.util.HashMap;
import java.util.Map;

public class AgendaTfno
{
	private Map<String, String> agenda = new HashMap<>();

	public void anadeTelefono(String nombre, String tfno)
	{
		agenda.put(nombre, tfno);
	}

	public String getTfno(String nombre)
	{
		return agenda.get(nombre);
	}

}